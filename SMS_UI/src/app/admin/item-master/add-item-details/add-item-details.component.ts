import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-item-details',
  templateUrl: './add-item-details.component.html',
  styleUrls: ['./add-item-details.component.css']
})
export class AddItemDetailsComponent implements OnInit {

  itemTitle:string = "Add New Item"
  categoryId:string= '';

  form: FormGroup = new FormGroup({});
  constructor(private fb: FormBuilder) { }

  @Output() formStatus = new EventEmitter<any>();

  currentItemInfo : any = this.initFormData();

  @Input() editItemData: any;
  ngOnChanges() {
    if(this.editItemData?.itemName){
      this.itemTitle = 'Edit Item';
        this.categoryId = this.editItemData.categoryId;
        this.currentItemInfo = this.editItemData;
                
      console.log('Edit Mode', this.editItemData)
    }
  }

  private initFormData (){
    return {
      categoryId: '',
      itemName: '',
      description: ''
    };

  }
  
  createNewFormObject(itemInfo: any){
    return this.fb.group({
      categoryId: [itemInfo.categoryId, [Validators.required]],
      itemName: [itemInfo.itemName, [Validators.required]],
      description: [itemInfo. description],
    });
  }

  ngOnInit(): void {
    this.form = this.createNewFormObject(this.currentItemInfo);
  }


  saveItemDetails (formData:any){
    const itemData = formData.value;
    ///Validate form data
    itemData.categoryId = this.categoryId;
    itemData.formStatus = false;
    this.formStatus.emit(itemData);

  }

  cancleItemDetails (){

    this.currentItemInfo = this.initFormData();
    this.formStatus.emit(null);
  }


}
