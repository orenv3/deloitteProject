import { ServCustService } from './../../service/serv-cust.service';
import { Component, OnInit } from '@angular/core';
import { Customer } from '../../common/Customer';

@Component({
  selector: 'app-get-all-customers',
  templateUrl: './get-all-customers.component.html',
  styleUrls: ['./get-all-customers.component.css']
})
export class GetAllCustomersComponent implements OnInit {

  public custArry : Customer[];
  constructor(private service : ServCustService) { }

  ngOnInit() {
    this.getAllCustomers();
  }

  getAllCustomers(){
    const self = this;
    this.custArry = new Array;
    return this.service.getAllCustomers().subscribe(
      function(result){
        for(let cust of result){
          cust = new Customer(cust);
          self.custArry.push(cust);
        }
      }
    )
  }
}
