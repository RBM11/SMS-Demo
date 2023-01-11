import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AddRegistrationComponent } from './registration/add-registration/add-registration.component';
import { ViewRegistrationDataComponent } from './registration/view-registration-data/view-registration-data.component';
import { AddCatetoryDetailsComponent } from './category-master/add-catetory-details/add-catetory-details.component';
import { ViewCatetoryDetailsComponent } from './category-master/view-catetory-details/view-catetory-details.component';
import { AddItemDetailsComponent } from './item-master/add-item-details/add-item-details.component';
import { ViewItemDetailsComponent } from './item-master/view-item-details/view-item-details.component';
import { HomePageComponent } from './item-master/home-page/home-page.component';
import { ShoppingComponent } from './shopping/shopping.component';
import { ReportsComponent } from './reports/reports/reports.component';

import { MaterialModule } from './material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserRegistrationComponent } from './registration/user-registration.component';
import { CategoryComponent } from './category-master/category.component';
import { ItemsComponent } from './item-master/items.component';
import { CamelCasePipe } from '../pipe/camel-case.pipe';


@NgModule({
  declarations: [
    AdminDashboardComponent,
    HeaderComponent,
    FooterComponent,
    
    AddRegistrationComponent,
    ViewRegistrationDataComponent,
    UserRegistrationComponent,

    AddCatetoryDetailsComponent,
    ViewCatetoryDetailsComponent,
    CategoryComponent,

    AddItemDetailsComponent,
    ViewItemDetailsComponent,
    ItemsComponent,

    HomePageComponent,
    ShoppingComponent,
    ReportsComponent,
    CamelCasePipe
    

  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AdminModule { }
