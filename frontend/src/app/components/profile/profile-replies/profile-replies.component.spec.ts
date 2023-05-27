import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileRepliesComponent } from './profile-replies.component';

describe('ProfileRepliesComponent', () => {
  let component: ProfileRepliesComponent;
  let fixture: ComponentFixture<ProfileRepliesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileRepliesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfileRepliesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
