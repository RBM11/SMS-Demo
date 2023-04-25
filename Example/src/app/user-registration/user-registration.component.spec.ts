<<<<<<< HEAD

=======
import { ComponentFixture, TestBed } from '@angular/core/testing';
>>>>>>> 30c6c0918bfca8eead2ae45abad7721d0f385d80

import { UserRegistrationComponent } from './user-registration.component';

describe('UserRegistrationComponent', () => {
  let component: UserRegistrationComponent;
  let fixture: ComponentFixture<UserRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserRegistrationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
<<<<<<< HEAD
function beforeEach(arg0: () => Promise<void>) {
  throw new Error('Function not implemented.');
}

=======
>>>>>>> 30c6c0918bfca8eead2ae45abad7721d0f385d80
