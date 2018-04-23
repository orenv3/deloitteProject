import {  Customer} from './../common/Customer';
import {  Injectable} from '@angular/core';
import {  Http} from '@angular/Http'
import 'rxjs/add/operator/map';


@Injectable()
export class ServCustService {

  private customer: Customer = new Customer();
  constructor(private _http: Http) {}

  createCustomer(cust: Customer) {
    return this._http.put("http://localhost:8080/restCustomer/createCustomer", cust);
  }

  getAllCustomers() {
    return this._http.get("http://localhost:8080/restCustomer/getAllCustomers").map(
      function (result) {
        return result.json();
      }
    );
  }

  getCustomer(id: number) {
    return this._http.get("http://localhost:8080/restCustomer/getCustomer/" + id).map(
      function (result) {
        return result.json();
      }
    )
  }

  deleteCustomer(cust: Customer) {
    return this._http.delete("http://localhost:8080/restCustomer/deleteCustomer", {
      body: cust
    }).map(
      function (response) {
        console.log(response);
      }
    );
  }


  updateCustoemr(cust: Customer) {
    return this._http.post("http://localhost:8080/restCustomer/updateCustomer/", cust).map(
function(response){
  console.log(response);
}
    );
  }



}

