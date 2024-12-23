package view;

import business.BasketController;
import business.CartController;
import core.Helper;
import entity.Basket;
import entity.Customer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CartUI extends JFrame {
    private JPanel container;
    private JLabel lbl_title;
    private JLabel lbl_customer_name;
    private JTextField fld_cart_date;
    private JTextArea tarea_cart_note;
    private JButton btn_card;
    private Customer customer;
    private BasketController basketController;
    private CartController cartController;
    public  CartUI(Customer customer) {
        this.customer = customer;
        this.basketController = new BasketController();
        this.cartController = new CartController();
        this.container = new JPanel();
        this.add(container);
        this.setTitle("Sipariş Oluştur ");
        this.setSize(300, 350);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;
        this.setLocation(x, y);
        this.setVisible(true);

        if (customer.getId() == 0) {

            Helper.showMsg("Lütfen Geçerli Bir Müşteri Seçiniz");
            dispose();
        }
        ArrayList<Basket> baskets = this.basketController.findAll();
        if (baskets.size() == 0) {
            Helper.showMsg("Lütfen Sepete Ürün Ekleyiniz");
            dispose();
        }

    }


}
