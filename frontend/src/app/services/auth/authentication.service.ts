import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs';
import { User } from 'src/app/model/user';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }


  loginUser(user: User) {
    const URLS = `${environment.loginUrl}`;
    return this.http.post<any>(URLS, user).pipe(
      tap((response: { token: string; }) => {
        if (response && response.token) {
          localStorage.setItem('currentUser', response.token);
        }
      })
    );
  }
}
