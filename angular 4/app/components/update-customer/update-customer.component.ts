import { ServCustService } from './../../service/serv-cust.service';
import { Component, OnInit } from '@angular/core';
import { Customer } from '../../common/Customer';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  public myAlert : String;
  public cust : Customer = new Customer();
  constructor(private service:ServCustService) { 
  }
  
  ngOnInit() {
  }

  updateCustomer(){
    this.cust = new Customer(this.cust);
    const self = this;
    return this.service.updateCustoemr(this.cust).subscribe(
      function(response){
        console.log(response);
        self.myAlert = "The update successfully implemented.";
      },(err:Response)=>{
        self.myAlert = err.text()+"";
      }
    )
  }
  getCustomer() {
    const self = this;
    if(this.cust.id==null){
      this.cust.id=-1;
      this.cust = new Customer(this.cust);
    }
    return this.service.getCustomer(self.cust.id).subscribe(
      function (result) { 
        self.cust = new Customer(result);
        console.log(result);
      }, (err: Response) => {
        self.myAlert = err.text()+"";
      }
    );

  }
}
