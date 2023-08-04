import { Component, ElementRef, HostListener, OnInit, Renderer2 } from '@angular/core';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  options = 'for you';

  constructor(private elementref:ElementRef, private renderer:Renderer2, private Auth: AuthenticationService) {}


  ngOnInit(): void {
    
  }

  toggleoptions(value: string) {
    this.options = value;
  }

  @HostListener('window:scroll')
  onWindowScroll(){
    const nav = this.elementref.nativeElement.querySelector('.nav')
    if (window.pageYOffset > nav.offsetTop) {
      this.renderer.addClass(nav, 'fixed-top');
    } else {
      this.renderer.removeClass(nav, 'fixed-top');
    }
  }
  
}
