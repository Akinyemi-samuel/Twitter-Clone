import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileTweetComponent } from './profile-tweet.component';

describe('ProfileTweetComponent', () => {
  let component: ProfileTweetComponent;
  let fixture: ComponentFixture<ProfileTweetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileTweetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfileTweetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
