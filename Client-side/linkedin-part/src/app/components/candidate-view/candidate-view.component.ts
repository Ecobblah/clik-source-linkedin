import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { LinkedinService } from 'src/app/services/linkedin.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-candidate-view',
  templateUrl: './candidate-view.component.html',
  styleUrls: ['./candidate-view.component.css']
})
/*
  Requirements: token and userName
*/
export class CandidateViewComponent implements OnInit {

  // Where we pass the access token
  // tslint:disable-next-line: max-line-length
  token = 'AQV2_kbB231dEMNxSlymX36NCNUagIAe33pouU76yHM0U-ZE7bZTMTj75RkpMKGGQ-SSrOE9yp1Wds3hAd8bBUJLU2qDAPlwz4icPg_yJCrsnR6ow8np8szSTdb9N1XOwjU7jsWEFokbpgXfrNwdVd_f9f4kuwZ0hRMabaHIug99mk74quf_ZLSBdiVVhwwaj6RdnNPMQdtfWZFYekbE5YPANDXuhRDPY3P46m6LIV73ALqA46iLLCYfasxOgyjhpaWxPDsmmt3mUA-hNgarKRb5zSlK1tWmVOxm6ERvwab9mqlQMWRyv6PExGBWWZ5dAG-jOzmhk1DG9J48LDUdMTc3OvxscA';
  // Where we pass thenUser name
  userName = "Manny";
  link = 'https://www.linkedin.com/in/' + 'userName';
  firstName: string;
  lastName: string;
  id: string;
  country: string;
  language: string;
  imgCode: string;
  profileForm = this.fb.group({
    accessToken: [''],
  });

  constructor(private fb: FormBuilder, private service: LinkedinService, private snackBar: MatSnackBar) { }

  onSubmit() {
    //console.log(this.profileForm.value.accessToken);
    this.profileForm.reset();
    // Post and get Data
    this.service.postData(this.token, this.userName).subscribe(
      (data: any) => {
      this.openSnackbar('', 'Saved!');
      this.firstName = data.info.localizedFirstName;
      this.lastName = data.info.localizedLastName;
      this.id = data.info.id;
      this.language = data.info.firstName.preferredLocale.language;
      this.country = data.info.firstName.preferredLocale.country;
      this.imgCode = data.info.profilePicture.displayImage;
      console.log(data);
    },
      (error) => {
        this.openSnackbar('Message: ' + error.error.text + ' with status code ' + error.status + ' ' + error.statusText, 'error');
        console.log('Message: ' + error.error.text + ' with status code ' + error.status + ' ' + error.statusText);
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
