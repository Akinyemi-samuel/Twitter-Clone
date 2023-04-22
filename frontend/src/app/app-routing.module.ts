import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SplashScreenComponent } from './components/splash-screen/splash-screen.component';
import { HomeComponent } from './components/home/home.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { Authguard } from './authguard';
import { ChildRoutingModule } from './child/child-routing.module';
import { LoggedOutComponent } from './components/logged-out/logged-out.component';

const routes: Routes = [
  { path: '', redirectTo: '/splashscreen', pathMatch: 'full' },
  { path: 'splashscreen', component: SplashScreenComponent },
  { path: 'navigation', component: NavigationComponent, canActivate: [Authguard], loadChildren: () => ChildRoutingModule },
  { path: 'loggedout', component: LoggedOutComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
