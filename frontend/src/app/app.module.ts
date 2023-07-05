import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SplashScreenComponent } from './components/splash-screen/splash-screen.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { HomeComponent } from './components/home/home.component';
import { LoggedOutComponent } from './components/logged-out/logged-out.component';
import {MatDialogModule} from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LogginDialogComponent } from './components/loggin-dialog/loggin-dialog.component';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { ExploreComponent } from './components/explore/explore.component';
import { MessagesComponent } from './components/messages/messages.component';
import { NotificationsComponent } from './components/notifications/notifications.component';
import { BookmarksComponent } from './components/bookmarks/bookmarks.component';
import { ProfileComponent } from './components/profile/profile.component';
import { TweetListComponent } from './components/tweets/tweet-list/tweet-list.component';
import { TrendsComponent } from './components/trends/trends.component';
import { NavigationLinksComponent } from './components/navigation-links/navigation-links.component';
import { ProfileTweetComponent } from './components/profile/profile-tweet/profile-tweet.component';
import { ProfileRepliesComponent } from './components/profile/profile-replies/profile-replies.component';
import { ProfileMediaComponent } from './components/profile/profile-media/profile-media.component';
import { ProfileLikesComponent } from './components/profile/profile-likes/profile-likes.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    SplashScreenComponent,
    NavigationComponent,
    HomeComponent,
    LoggedOutComponent,
    LogginDialogComponent,
    ExploreComponent,
    MessagesComponent,
    NotificationsComponent,
    BookmarksComponent,
    ProfileComponent,
    TweetListComponent,
    TrendsComponent,
    NavigationLinksComponent,
    ProfileTweetComponent,
    ProfileRepliesComponent,
    ProfileMediaComponent,
    ProfileLikesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatDialogModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
