import { ServCustService } from './../../service/serv-cust.service';
import { Component, OnInit } from '@angular/core';
import { Customer } from '../../common/Customer';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-get-customer',
  templateUrl: './get-customer.component.html',
  styleUrls: ['./get-customer.component.css']
})
export class GetCustomerComponent implements OnInit {
  public myAlert: String;
  public cust: Customer = new Customer();
  constructor(private customerService: ServCustService) {}

  ngOnInit() {

  }

  getCustomer() {
    const self = this;
    if(this.cust.id == null){
      this.cust.id=-1;
    }
      return this.customerService.getCustomer(self.cust.id).subscribe(
        function (result) {
          self.cust = new Customer(result);
          console.log(result);
        }, (err: Response) => {
          self.myAlert = err.text()+"";
        }
      );

    

  }


}
