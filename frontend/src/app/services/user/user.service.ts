import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthenticationService } from '../auth/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private auth: AuthenticationService) { }

  getUserProfileDetails(){

    const headers = this.auth.getTokenHeaders()

     return this.http.get<any>('http://localhost:8082/API/V1/USER/USER_ID', {
      headers,
    });
  }
}
