import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent {
  options = 'for you';

  toggleoptions(value: string) {
    this.options = value;
  }
}
