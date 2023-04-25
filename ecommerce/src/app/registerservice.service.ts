import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reguser } from './reguser';

@Injectable({
  providedIn: 'root'
})
export class RegisterserviceService {
baseurl="http://localhost:8081/user";
  constructor(private httClient :HttpClient) { }



  registerUser(registeruser : Reguser) : Observable<object>{
    console.log(registeruser);
    return this.httClient.post('${this.baseUrl}',registeruser);
  }
}
