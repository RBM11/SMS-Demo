import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCatetoryDetailsComponent } from './add-catetory-details.component';

describe('AddCatetoryDetailsComponent', () => {
  let component: AddCatetoryDetailsComponent;
  let fixture: ComponentFixture<AddCatetoryDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCatetoryDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCatetoryDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
