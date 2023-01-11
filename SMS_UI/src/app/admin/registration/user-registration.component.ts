import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  showRegistrationForm: boolean = false;
  title: string = 'User Registration'

  public newUserInfo: any = {};
  public editUserInfoData: any = {};

  constructor() { }

  formOpenStatusHandler(userData: any) {
    ///Hide registration form panel
    this.showRegistrationForm = false;

    if (userData) {
      this.newUserInfo = userData;
    }

  }

  editRegistrationForm(userData: any) {    
    ///Set Edit User Information to send info to add user panel
    this.editUserInfoData = userData;

    //Display form panel after clicking on edit button
    this.showRegistrationForm = true;

  }

  displayRegistrationForm() {
    ////Clear Edit User info Object before opening new user
    this.editUserInfoData = {};

    ///Show registration form panel
    this.showRegistrationForm = true;
  }

  ngOnInit(): void {
  }

}
