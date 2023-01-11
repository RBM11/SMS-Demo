import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpServiceService } from '../service/http-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy  {

  private imageNumber : number = 1;
  public imagePath ="assets/images/1.jpg";
  private interval : any;
  public validator = this.loginFormValidator();
  public loginFailure = false;



  constructor(private httpService: HttpServiceService, private router: Router) { }

  private loginFormValidator(){
    return {userId:false, password:false};
  }

  ngOnDestroy(): void {
    clearInterval(this.interval);
  }

  submitButtonClicked(loginFormData: NgForm) {

    const loginData = loginFormData.value;
    this.validator.userId = loginData.userId === '';
    this.validator.password = loginData.password === '';

    if(loginFormData.valid){

      this.loginFailure = false;

      this.httpService.processPostRequest('authenticateUser',loginData).subscribe((resonseData)=>{
          
        this.router.navigateByUrl('/admin')
      }, error => {
        this.loginFailure = true;
      });

      console.log(loginData);
    }

  }


  ngOnInit(): void {


    this.interval = setInterval(() => {
      if(this.imageNumber == 4){
        this.imageNumber = 1;
      }else{
        this.imageNumber = this.imageNumber + 1;
      }
      this.imagePath ='assets/images/'+this.imageNumber+'.jpg';
    },5000)

   
   }


}
