import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Route, Router, RouterStateSnapshot, UrlSegment, UrlTree } from "@angular/router";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
  })
export class Authguard implements CanActivate {
    isLogged:boolean = true
    constructor(private router: Router) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        return this.authenticateUser()
    }
   

    authenticateUser(){
         if(this.isLogged){
            return true
         }else{
            this.router.navigateByUrl('/loggedout')
         }
         return this.isLogged
    }
}
