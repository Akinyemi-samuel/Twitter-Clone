import { Component } from '@angular/core';

@Component({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.scss']
})
export class TrendsComponent {


   products: Product[] = [
    { location: 'Trends in Nigeria', topic: 'Brother Benard', amount:17.4 },
    { location: 'Trends in Nigeria', topic: '#GirlsinICT', amount:8.53 },
    { location: 'Trends in Nigeria', topic: 'NEWCASTLE WELCOMES KHOSI', amount:17.4 },
    { location: 'Trends in Nigeria', topic: 'Airport', amount:111.4 },
    { location: 'Trends in Nigeria', topic: 'Effie', amount:100.4 },
    { location: 'Trends in Nigeria', topic: 'Deborah', amount:660.4 },
    { location: 'Trends in Nigeria', topic: 'Deborah', amount:660.4 },
    { location: 'Trends in Nigeria', topic: 'Deborah', amount:660.4 },
    { location: 'Trends in Nigeria', topic: 'Deborah', amount:660.4 },
    
  ];
  
}

interface Product {
  location: string;
  topic: string;
  amount: number;
}
