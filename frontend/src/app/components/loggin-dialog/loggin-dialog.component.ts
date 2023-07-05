import { Component, ElementRef, Renderer2 } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-loggin-dialog',
  templateUrl: './loggin-dialog.component.html',
  styleUrls: ['./loggin-dialog.component.scss']
})
export class LogginDialogComponent {
  form: any;
  error_msg!: string;

  constructor(
    public dialogRef: MatDialogRef<LogginDialogComponent>,
    private elRef: ElementRef,
    private renderer: Renderer2){
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
      console.log(this.form.value);
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
