import { Component } from '@angular/core';
import { LoginuserService } from '../loginuser.service';
import { User } from '../user';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {
user : User= new User();

constructor(private loginuserservice: LoginuserService){}
userLogin() {
  console.log(this.user);
  this.loginuserservice.loginUser(this.user).subscribe(data=>{
    alert("login successfully")
  },error=>alert("sorry please enter correct username and password"))
}

}

