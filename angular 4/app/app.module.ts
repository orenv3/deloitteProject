import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { HttpModule } from '@angular/Http';
import {RouterModule} from '@angular/router'

import { AppComponent } from './app.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';
import { DeleteCustomerComponent } from './components/delete-customer/delete-customer.component';
import { GetCustomerComponent } from './components/get-customer/get-customer.component';
import { GetAllCustomersComponent } from './components/get-all-customers/get-all-customers.component';
import { CreateCustomerComponent } from './components/create-customer/create-customer.component';
import { ServCustService } from './service/serv-cust.service';

@NgModule({
  declarations: [
    AppComponent,
    UpdateCustomerComponent,
    DeleteCustomerComponent,
    GetCustomerComponent,
    GetAllCustomersComponent,
    CreateCustomerComponent
  ],
  imports: [
    HttpModule,
    FormsModule,
    BrowserModule,
    RouterModule.forRoot([
      {
        path:'createCustomer',
        component: CreateCustomerComponent

      },
      {
        path: 'getCustomer',
        component: GetCustomerComponent
      },
      {
        path:'deleteCustomer',
        component: DeleteCustomerComponent
      },
      {
        path:'getAllCustomers',
        component: GetAllCustomersComponent
      },
      {
        path:'updateCustomer',
        component: UpdateCustomerComponent
      }
    ])
  ],
  providers: [ServCustService],
  bootstrap: [AppComponent]
})
export class AppModule { }
