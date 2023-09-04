import { Component, OnInit } from '@angular/core';
import { UserProfile } from 'src/app/model/user-profile';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

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

  // onFileSelected(event: any) {
  //   this.selectedFile = event.target.files[0];
  // }

  // onUpload() {
  //   if (!this.selectedFile) {
  //     // Handle case where no file is selected
  //     console.log("no file selected");
  //     return;
  //   }

  //   const formData = new FormData();
  //   formData.append('file', this.selectedFile, this.selectedFile.name);

  //   console.log(this.selectedFile);
  // }

}
