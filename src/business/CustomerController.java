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
    public ArrayList<Customer> filter(String name, Customer.TYPE type) {
        // Dinamik WHERE koşulları oluşturuluyor
        String query = "SELECT * FROM customer ";
        ArrayList<String> whereList = new ArrayList<>();

        if (name != null && !name.trim().isEmpty()) {
            whereList.add("name LIKE '%" + name.trim() + "%'");
        }
        if (type != null) {
            whereList.add("type = '" + type.toString() + "'");
        }

        if (!whereList.isEmpty()) {
            query += "WHERE " + String.join(" AND ", whereList);
        }
        return this.customerDao.query(query);
    }
}