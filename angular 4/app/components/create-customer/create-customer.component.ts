import { ServCustService } from './../../service/serv-cust.service';
import { Component, OnInit } from '@angular/core';
import { Customer } from '../../common/Customer';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  public myAlert : String;
  public cust : Customer = new Customer();
  constructor(private customerService : ServCustService) { }

  ngOnInit() {
  }

  public createCustomer(){
    const self = this;
    this.cust = new Customer(this.cust);
    if(this.cust.address!=null && this.cust.name!=null && this.cust.phone!=null){
      return this.customerService.createCustomer(this.cust).subscribe(
        function(response){
          console.log(response);
          self.myAlert="The customer created successfully.";
        },(err:Response)=>{
          self.myAlert = err.text()+"";
        }
      )
    } this.myAlert = "Filling the fields is mandatory.";

    }
}
