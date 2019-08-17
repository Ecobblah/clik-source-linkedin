import { Component, OnInit } from '@angular/core';
import { LinkedinService } from 'src/app/services/linkedin.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-employer-view',
  templateUrl: './employer-view.component.html',
  styleUrls: ['./employer-view.component.css']
})
/*
  Requirements: userName
*/
export class EmployerViewComponent implements OnInit {
  // Were we pass the username
  // tslint:disable-next-line: max-line-length
  // userName = "default userName";
  userName = 'adam';
  link = 'https://www.linkedin.com/in/' + 'userName';
  firstName: string;
  lastName: string;
  id: string;
  country: string;
  language: string;
  imgCode: string;

  constructor(private service: LinkedinService, private snackBar: MatSnackBar) {
    service.getDataByUserName(this.userName).subscribe(
      (data: any) => {
        this.firstName = data.info.localizedFirstName;
        this.lastName = data.info.localizedLastName;
        this.id = data.info.id;
        this.language = data.info.firstName.preferredLocale.language;
        this.country = data.info.firstName.preferredLocale.country;
        this.imgCode = data.info.profilePicture.displayImage;
      },
      (error) => {
        this.openSnackbar( 'status code ' + error.status, 'Error');
        //console.log(error);
      }
    );
   }

  ngOnInit() {
  }

  openSnackbar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

}
