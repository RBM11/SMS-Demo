import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  //For Testing //http://localhost:9087/ssms/
  private serverURL = ''; 
  constructor(private httpClient: HttpClient) { }

    proccessGetRequest(endpoint:string): Observable<any> {
      return this.httpClient.get(this.serverURL + endpoint);
    }

    processPostRequest(endpoint:string, data:any): Observable<any> {
      return this.httpClient.post(this.serverURL + endpoint, data);
    }

    processPuRequest(endpoint:string, data:any): Observable<any> {
      return this.httpClient.put(this.serverURL + endpoint, data);
    }

    processDeleteRequest(endpoint:string, data:any): Observable<any> {
      return this.httpClient.delete(this.serverURL + endpoint, data);
    }
}
