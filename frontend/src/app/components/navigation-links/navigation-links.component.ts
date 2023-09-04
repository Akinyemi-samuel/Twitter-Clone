import { Component, OnInit } from '@angular/core';
import { UserProfile } from 'src/app/model/user-profile';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-navigation-links',
  templateUrl: './navigation-links.component.html',
  styleUrls: ['./navigation-links.component.scss']
})
export class NavigationLinksComponent implements OnInit {

  userProfile: UserProfile | undefined;
  selectedFile: File | undefined;
  constructor(private userService: UserService) {}


  ngOnInit(): void {
    this.getUserDetails()
  }

  getUserDetails(){
    this.userService.getUserProfileDetails().subscribe((data)=>{
      this.userProfile = data;
    }, (err)=>{
      console.log(err);
    })
  }

}
