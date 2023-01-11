import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCatetoryDetailsComponent } from './view-catetory-details.component';

describe('ViewCatetoryDetailsComponent', () => {
  let component: ViewCatetoryDetailsComponent;
  let fixture: ComponentFixture<ViewCatetoryDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewCatetoryDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCatetoryDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
