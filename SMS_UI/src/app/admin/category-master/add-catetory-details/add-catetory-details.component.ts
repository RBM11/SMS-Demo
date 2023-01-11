import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-catetory-details',
  templateUrl: './add-catetory-details.component.html',
  styleUrls: ['./add-catetory-details.component.css']
})
export class AddCatetoryDetailsComponent implements OnInit {

  categoryTitle:string = "Add New Category"

  form: FormGroup = new FormGroup({});
  constructor(private fb: FormBuilder) { }

  @Output() formStatus = new EventEmitter<any>();

  currentCategoryInfo : any = this.initFormData();

  @Input() editCategoryData: any;
  ngOnChanges() {
    if(this.editCategoryData?.categoryName){
      
        this.categoryTitle = "Edit Category";
        this.currentCategoryInfo = this.editCategoryData;
        console.log('Edit Mode', this.editCategoryData);      
    }
  }

  private initFormData (){
    return {
      categoryName: '',
      description: ''
    };

  }
  
  createNewFormObject(categoryInfo: any){
    return this.fb.group({
      categoryName: [categoryInfo.categoryName, [Validators.required]],
      description: [categoryInfo.description],
    });
  }

  ngOnInit(): void {
    this.form = this.createNewFormObject(this.currentCategoryInfo);
  }


  saveCategoryDetails (formData:any){
    const categoryData = formData.value;
    categoryData.formStatus = false;
    //this.formStatus.emit(categoryData);

  }

  cancleCategoryDetails (){

    this.currentCategoryInfo = this.initFormData();
    this.formStatus.emit(null);
  }

}
