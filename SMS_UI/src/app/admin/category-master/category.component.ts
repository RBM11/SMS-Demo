import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  showCategoryForm: boolean = false;
  title: string = 'Category Details'

  public newCategoryInfo: any = {};
  public editCategoryData: any = {};

  constructor() { }

  formOpenStatusHandler(categoryData: any) {
    ///Hide category form panel
    this.showCategoryForm = false;

    if (categoryData) {
      this.newCategoryInfo = categoryData;
    }

  }

  editCategoryDetails(categoryData: any) {    
    ///Set Edit category Information to send info to add user panel
    this.editCategoryData = categoryData;

    //Display form panel after clicking on edit button
    this.showCategoryForm = true;

  }

  displayCategoryForm() {
    ////Clear Edit User info Object before opening new user
    this.editCategoryData = {};

    ///Show category form panel
    this.showCategoryForm = true;
  }

  ngOnInit(): void {
  }


}

