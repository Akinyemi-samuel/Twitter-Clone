import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { LogginDialogComponent } from '../loggin-dialog/loggin-dialog.component';

@Component({
  selector: 'app-logged-out',
  templateUrl: './logged-out.component.html',
  styleUrls: ['./logged-out.component.scss']
})
export class LoggedOutComponent {
  darkmode = false;
  constructor(public dialog: MatDialog) {
    this.detectColorScheme()
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(LogginDialogComponent, {
      maxWidth: '600px',
      maxHeight: '600px',
      width: '100%',
      height: '100%',
      panelClass: 'dialog_box'
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log('The dialog was closed');
    });
  }


  detectColorScheme() {
    if (!(
      window.matchMedia &&
      window.matchMedia('(prefers-color-scheme: dark)').matches
    )) {
      this.darkmode = true;
      document.documentElement.setAttribute(
        'data-theme',
        this.darkmode ? 'dark' : 'light'
      );
    }
  }

  toogle() {
    this.darkmode = !this.darkmode;
    document.documentElement.setAttribute(
      'data-theme',
      this.darkmode ? 'dark' : 'light'
    );
  }

}
