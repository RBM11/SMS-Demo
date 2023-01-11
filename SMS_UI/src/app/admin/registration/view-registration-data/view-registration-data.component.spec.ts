import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRegistrationDataComponent } from './view-registration-data.component';

describe('ViewRegistrationDataComponent', () => {
  let component: ViewRegistrationDataComponent;
  let fixture: ComponentFixture<ViewRegistrationDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRegistrationDataComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewRegistrationDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
