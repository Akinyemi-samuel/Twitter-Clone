import { Component, ElementRef, HostListener, Renderer2 } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent {
  options = 'for you';

  constructor(private elementref:ElementRef, private renderer:Renderer2) {}

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
