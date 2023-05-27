import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfileComponent } from '../../components/profile/profile.component';
import { ProfileTweetComponent } from 'src/app/components/profile/profile-tweet/profile-tweet.component';
import { ProfileRepliesComponent } from 'src/app/components/profile/profile-replies/profile-replies.component';
import { ProfileMediaComponent } from 'src/app/components/profile/profile-media/profile-media.component';
import { ProfileLikesComponent } from 'src/app/components/profile/profile-likes/profile-likes.component';

const routes: Routes = [
  {path:'', component: ProfileTweetComponent},
  {path:'with_replies', component: ProfileRepliesComponent},
  {path:'media', component: ProfileMediaComponent},
  {path:'likes', component: ProfileLikesComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingRoutingModule { }
