import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-view-catetory-details',
  templateUrl: './view-catetory-details.component.html',
  styleUrls: ['./view-catetory-details.component.css']
})
export class ViewCatetoryDetailsComponent implements OnInit, OnChanges {

  constructor() { }
  @Output() editCategoryDetails = new EventEmitter<any>();
  categoryInfoList : any = [];
  
  @Input() categoryData: any;
  ngOnChanges() {
    if(this.categoryData?.categoryName){
      const newData = [ ...this.categoryInfoList]; 
        newData.push(this.categoryData);
        this.categoryInfoList = newData;
    }
  }


  editCategoryData(categoryData:any){
    console.log("Edit button",categoryData);

    this.editCategoryDetails.emit(categoryData);
  }

  displayedColumns : string[] =["Category Name", "Description", "Action"];

  ngOnInit(): void {
  }

}
