import { ServCustService } from './../../service/serv-cust.service';
import { Component, OnInit } from '@angular/core';
import { Customer } from '../../common/Customer';

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {

  public myAlert : String;
  public cust : Customer = new Customer();
  constructor(private service:ServCustService) { }

  ngOnInit() {
  }

  deleteCustomer(){
    const self = this;
    if(this.cust.id == null || this.cust.id == 0){
      this.cust.id=-1;
    }
    return this.service.deleteCustomer(this.cust).subscribe(
      function(response){
        console.log(response);
        self.myAlert = "The customer with id:"+ self.cust.id + " deleted successfully";
      },(err:Response)=>{
        self.myAlert = err.text()+"";
      }
    )
  }

}
