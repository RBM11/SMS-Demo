import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  showItemForm: boolean = false;
  title: string = 'Item Details'

  public newItemInfo: any = {};
  public editItemData: any = {};

  constructor() { }

  formOpenStatusHandler(itemData: any) {
    ///Hide Item form panel
    this.showItemForm = false;

    if (itemData) {
      this.newItemInfo = itemData;
    }

  }

  editItemDetails(itemData: any) {    
    ///Set Edit Item Information to send info to add user panel

    console.log('Item Info',itemData);

    this.editItemData = itemData;

    //Display form panel after clicking on edit button
    this.showItemForm = true;

  }

  displayItemForm() {
    ////Clear Edit User info Object before opening new user
    this.editItemData = {};

    ///Show Item form panel
    this.showItemForm = true;
  }

  ngOnInit(): void {
  }


}
