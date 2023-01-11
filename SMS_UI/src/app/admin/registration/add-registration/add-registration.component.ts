import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-registration',
  templateUrl: './add-registration.component.html',
  styleUrls: ['./add-registration.component.css']
})
export class AddRegistrationComponent implements OnInit,OnChanges {

  registrationTitle:string = "Add New User Details"

  form: FormGroup = new FormGroup({});
  constructor(private fb: FormBuilder) { }

  @Output() formStatus = new EventEmitter<any>();

  currentUserInfo : any = this.initFormData();

  @Input() editUserData: any;
  ngOnChanges() {
    if(this.editUserData?.firstName){
      console.log('Edit Mode', this.editUserData)
        this.currentUserInfo = this.editUserData;
    }
  }




  private initFormData (){
    return {
      firstName: '',
      lastName: '',
      gender: '',
      mobileNumber: '',
      email: '',
      address: '',
      userId: '',
      password: '',
      confirmPassword: ''
    };

  }
  


  createNewFormObject(currentUserInfo: any){
    return this.fb.group({
      firstName: [currentUserInfo.firstName, [Validators.required]],
      lastName: [currentUserInfo.lastName, [Validators.required]],
      gender: [currentUserInfo.gender],
      mobileNumber: [currentUserInfo.mobileNumber],
      email: [currentUserInfo.email, [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
      address: [currentUserInfo.address],
      userId: [currentUserInfo.userId],
      password: [currentUserInfo.password],
      confirmPassword: [currentUserInfo.confirmPassword]
    });
  }

  ngOnInit(): void {
    
    this.form = this.createNewFormObject(this.currentUserInfo);
  }


  saveRegistrationDetails (formData:any){
    const userData = formData.value;

    ///Validate form data

    userData.formStatus = false;


    this.formStatus.emit(userData);

  }

  cancleRegistrationDetails (){

    this.currentUserInfo = this.initFormData();
    this.formStatus.emit(null);
  }

}
