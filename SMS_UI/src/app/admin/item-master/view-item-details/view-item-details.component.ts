import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-view-item-details',
  templateUrl: './view-item-details.component.html',
  styleUrls: ['./view-item-details.component.css']
})
export class ViewItemDetailsComponent implements OnInit,OnChanges {

  
  constructor() { }
  @Output() editItemData = new EventEmitter<any>();
  itemInfoList : any = [];
  
  @Input() itemData: any;
  ngOnChanges() {
    if(this.itemData.itemName){
      const newData = [ ...this.itemInfoList]; 
        newData.push(this.itemData);
        this.itemInfoList = newData;
    }
  }


  editItemDetails(itemData:any){
    console.log("Edit button",itemData);
    this.editItemData.emit(itemData);
  }
  

  displayedColumns : string[] =["Category Id", "Category Name", "Item Name", " Description", "Action"];

  ngOnInit(): void {
  }

}
