import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../components/home/home.component';
import { ExploreComponent } from '../components/explore/explore.component';
import { NotificationsComponent } from '../components/notifications/notifications.component';
import { MessagesComponent } from '../components/messages/messages.component';
import { BookmarksComponent } from '../components/bookmarks/bookmarks.component';
import { ProfileComponent } from '../components/profile/profile.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {path:'home', component:HomeComponent},
  {path:'explore', component:ExploreComponent},
  {path:'notifications', component:NotificationsComponent},
  {path:'messages', component:MessagesComponent},
  {path:'bookmarks', component:BookmarksComponent},
  {path:':name', component:ProfileComponent},
  {path:'messages', component:ExploreComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ChildRoutingModule { }
