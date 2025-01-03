package business;

import core.Helper;
import dao.CustomerDao;
import entity.Customer;

import java.util.ArrayList;

public class CustomerController {
    private final CustomerDao customerDao=new CustomerDao();

    public ArrayList<Customer> findAll() {
        return this.customerDao.findAll();
    }
    public boolean save (Customer customer) {
        return this.customerDao.save(customer);
    }
    public Customer getById(int id){
        return   this.customerDao.getById(id);
    }
    public  Customer update(Customer customer) {
        if (this.getById(customer.getId())==null){
            Helper.showMsg(customer.getId()+"  ID kayıtlı müşteri bulunamadı!!");
            return null;
        }
        return this.customerDao.update(customer);
    }
    public boolean delete(int id) {
        if (this.getById(id)==null){
            return false;
        }
        return this.customerDao.delete(id);
    }
}