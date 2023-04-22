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

  }
  verifyUser(){
    console.log(this.form.value);
    if(!this.email.errors?.required){
      const emailsection = this.elRef.nativeElement.querySelector('.email_section')
      const passwordsection = this.elRef.nativeElement.querySelector('.password_section')
  
      this.renderer.setStyle(emailsection,'display','none')
      this.renderer.setStyle(passwordsection,'display','block')
    }else{
      console.log("object");
    }
    

  }
}
