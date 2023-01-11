import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from '../page-not-found/page-not-found.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AddCatetoryDetailsComponent } from './category-master/add-catetory-details/add-catetory-details.component';
import { CategoryComponent } from './category-master/category.component';
import { ViewCatetoryDetailsComponent } from './category-master/view-catetory-details/view-catetory-details.component';
import { AddItemDetailsComponent } from './item-master/add-item-details/add-item-details.component';
import { HomePageComponent } from './item-master/home-page/home-page.component';
import { ItemsComponent } from './item-master/items.component';
import { ViewItemDetailsComponent } from './item-master/view-item-details/view-item-details.component';
import { AddRegistrationComponent } from './registration/add-registration/add-registration.component';
import { UserRegistrationComponent } from './registration/user-registration.component';
import { ViewRegistrationDataComponent } from './registration/view-registration-data/view-registration-data.component';
import { ReportsComponent } from './reports/reports/reports.component';
import { ShoppingComponent } from './shopping/shopping.component';

const routes: Routes = [
  {path:'', component:AdminDashboardComponent, children:[
    {path:'home',component:HomePageComponent},
    {path:'registration',component:UserRegistrationComponent},
    {path:'items',component:ItemsComponent},
    {path:'category',component:CategoryComponent},
    {path:'shopping',component:ShoppingComponent},
    {path:'reports',component:ReportsComponent},
    {path:'', redirectTo:'/admin/home', pathMatch:'full'},
    {path:'**',redirectTo:'/login', pathMatch:'full'}
  ]}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
