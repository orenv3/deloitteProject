// package deloitte.jpa.dao;
//
// import java.util.ArrayList;
//
// import org.junit.AfterClass;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;
//
// import deloitte.jpa.beans.Customer;
// import deloitte.jpa.customerExceptions.CustomerExistException;
// import deloitte.jpa.customerExceptions.CustomerNotFoundException;
//
// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class CustomerDaoTest {
//
// @Autowired
// CustomerDB_Dao customerDb;
//
// @Test
// public void contextLoads() {
// }
//
// @AfterClass
// public static void afterAll() {
// System.out.println("************** @AfterClass **************");
// }
//
// @Test
// public void test() {
//
// // __________________________
// /// ///// create /////////
//
// for (int i = 0; i < 4; i++) {
// Customer customer = new Customer();
// customer.setName("VinoguraOren" + i);
// customer.setAddress("AddressOren" + i);
// customer.setPhone(1000000 * (i + 1));
// try {
// customerDb.create(customer);
// } catch (CustomerExistException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// }
//
// // ____________________________
// //////// get customer //////
// //
// System.out.println("============= get customer ===============");
// System.out.println("get customer: " + customerDb.getCustomer(2).get());
// System.out.println("============= get all customers ===============");
// ArrayList<Customer> list = customerDb.getAllCustomers();
// for (Customer customer : list) {
// System.out.println(customer + " ||");
// }
//
// // ____________________________
// //////// update customer //////
// try {
// System.out.println("============= update ===============");
// customerDb.update(2, "Avivit", "good address", 052222456);
// System.out.println("============================");
// System.out.println("get customer: " + customerDb.getCustomer(2).get());
// } catch (CustomerNotFoundException | CustomerExistException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
//
// // // ____________________________
// // //////// delete customer //////
// // System.out.println("=========== DELETE =================");
// // try {
// // customerDb.delete(1);
// // } catch (CustomerNotFoundException e1) {
// // // TODO Auto-generated catch block
// // e1.printStackTrace();
// // }
// // ArrayList<Customer> list2 = customerDb.getAllCustomers();
// // for (Customer customer : list2) {
// // System.out.println(customer + " ||");
// // }
// // System.out.println("=========== Get by name =================");
// // try {
// // System.out.println("customer by name: " +
// // customerDb.getByName("VinoguraOren3"));
// // } catch (CustomerExistException e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// }
// }
