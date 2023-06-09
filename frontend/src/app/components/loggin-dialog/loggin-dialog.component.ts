import { Component, ElementRef, Renderer2 } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';

@Component({
  selector: 'app-loggin-dialog',
  templateUrl: './loggin-dialog.component.html',
  styleUrls: ['./loggin-dialog.component.scss']
})
export class LogginDialogComponent {
  form: any;
  error_msg!: string;
  user!: User;

  constructor(
    public dialogRef: MatDialogRef<LogginDialogComponent>,
    private elRef: ElementRef,
    private renderer: Renderer2,
    private authenticationService: AuthenticationService,
    private router: Router){
    this.form = new FormGroup({
      email: new FormControl('', [Validators.required]),
      password: new FormControl('',[Validators.required])
    });
  }

  get email(){
    return this.form.get('email')
  }
  get password(){
    return this.form.get('password')
  }


  // AN HANDLER METHOD THAT CLOSES THE DIALOG ON CLICK
  onNoClick(): void {
    this.dialogRef.close();
  }

  LogInUser(){
    const error_section = this.elRef.nativeElement.querySelector('.error_dialog')
    if (!this.password.errors?.required) {
      this.user = this.form.value;
      this.authenticationService.loginUser(this.user).subscribe((data)=>{
        this.router.navigateByUrl('/i')
        this.onNoClick();
      }, (err)=>{
        console.log("error"+err);
      })
      
    }else{
      this.renderer.setStyle(error_section,'display','block')
      this.error_msg = "Fields cannot be empty"
      setTimeout(()=>{
        this.renderer.setStyle(error_section,'display','none')
      }, 3000)
    }
  }

  verifyUser(){
    const error_section = this.elRef.nativeElement.querySelector('.error_dialog')
    const emailsection = this.elRef.nativeElement.querySelector('.email_section')
    const passwordsection = this.elRef.nativeElement.querySelector('.password_section')
    if(!this.email.errors?.required){
      this.renderer.setStyle(emailsection,'display','none')
      this.renderer.setStyle(passwordsection,'display','block')
    }else{
      this.renderer.setStyle(error_section,'display','block')
      this.error_msg = "Fields cannot be empty"
      setTimeout(()=>{
        this.renderer.setStyle(error_section,'display','none')
      }, 3000)
     
    }
    

  }
}
