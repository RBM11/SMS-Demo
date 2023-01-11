import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-view-registration-data',
  templateUrl: './view-registration-data.component.html',
  styleUrls: ['./view-registration-data.component.css']
})
export class ViewRegistrationDataComponent implements OnInit, OnChanges {

  constructor() { }
  
  @Output() editFormDetails = new EventEmitter<any>();
  userInfoList : any = [];
  
  @Input() userData: any;
  ngOnChanges() {
    if(this.userData?.firstName){
      const newData = [ ...this.userInfoList]; 
        newData.push(this.userData);
        this.userInfoList = newData;
    }
  }


  editRegistrationForm(userData:any){
    console.log("Edit button",userData);

    this.editFormDetails.emit(userData);
  }

  displayedColumns : string[] =["First Name", "Last Name", "User Id", "Gender","Mobile Number","Email","Address", "Action"];

  ngOnInit(): void {
  }

}
