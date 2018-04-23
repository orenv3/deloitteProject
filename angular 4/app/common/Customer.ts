
export class Customer{
    public id:number;
    public name:String;
    public address:String;
    public phone:number;

    constructor(private customer ? : Customer){
       if(customer != null){
           this.id = customer.id;
           this.name = customer.name;
           this.address = customer.address;
           this.phone = customer.phone;
       }
    }
}