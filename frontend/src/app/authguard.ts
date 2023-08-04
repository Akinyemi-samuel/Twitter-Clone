import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Route, Router, RouterStateSnapshot, UrlSegment, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AuthenticationService } from "./services/auth/authentication.service";
import { UserService } from "./services/user/user.service";

@Injectable({
    providedIn: 'root'
  })
export class Authguard implements CanActivate {
    // I AM HARD CODDING THE THE USER LOGIN STATUS ... IT WILL BE UPDATED LATER AS THE PROJECT GOES ON
    isLogged:boolean = false
    constructor(private router: Router, private Auth: AuthenticationService,
         private userService: UserService) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        return this.authenticateUser()
        
    }
   

    authenticateUser(){
         if(this.Auth.getToken() != null){
          this.isLogged = true
          this.userService.getUserProfileDetails().subscribe((data)=>{
            this.isLogged = true
          }, (err)=>{
            this.isLogged = false
            this.router.navigateByUrl('/loggedout')
          })
         }else{
            this.isLogged = false
            this.router.navigateByUrl('/loggedout')
          }
         return this.isLogged
    }
}
