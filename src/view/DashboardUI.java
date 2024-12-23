package view;

import business.CustomerController;
import core.Helper;
import entity.Customer;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DashboardUI extends JFrame {
    private JPanel container;
    private JPanel pnl_top;
    private JLabel lbl_welcome;
    private JButton btn_logout;
    private JTabbedPane tabbedPane1;
    private JPanel pnl_customer;
    private JScrollPane scrl_customer;
    private JTable tbl_customer;
    private JPanel pnl_customer_filter;
    private JTextField fld_f_customer_name;
    private JComboBox cmb_customer_type;
    private JButton btn_customer_filter;
    private JButton btn_customer_filter_reset;
    private JButton btn_customer_new;
    private JLabel lbl_f_customer_name;
    private JLabel lbl_filter_customer_type;
    private User user;
    private  CustomerController customerController;
    private DefaultTableModel tmdl_customer=new DefaultTableModel();
    private JPopupMenu popup_customer =new JPopupMenu();

    public DashboardUI(User user) {
        this.user = user;
        this.customerController = new CustomerController();
        if (user==null){
            Helper.showMsg("error");
            dispose();

        }
        this.add(container);
        this.setTitle("Müşteri Yönetim Sistemi");
        this.setSize(1000,500);
        int x=(Toolkit.getDefaultToolkit().getScreenSize().width-this.getWidth())/2;
        int y=(Toolkit.getDefaultToolkit().getScreenSize().height-this.getHeight())/2;
        this.setLocation(x,y);
        this.setVisible(true);

    this.lbl_welcome.setText("Hoşgeldin:  "+this.user.getName());
        this.btn_logout.addActionListener(e-> {
            dispose();
            LoginUI loginUI=new LoginUI();
        });
        loadCustomerTable(null);
        loadCustomerPopupMenu();

    }
    private void loadCustomerPopupMenu() {

        this.tbl_customer.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow=tbl_customer.rowAtPoint(e.getPoint());
                tbl_customer.setColumnSelectionInterval(selectedRow,selectedRow);
            }
        });

        this.popup_customer.add("Güncelle").addActionListener(e->{
            int selecteId= (int) tbl_customer.getValueAt(tbl_customer.getSelectedRow(),0);
            System.out.println(selecteId);
       });
        this.popup_customer.add("Sil").addActionListener(e->{
            System.out.println("Sil Tıklandı");
        });
        this.tbl_customer.setComponentPopupMenu(this.popup_customer);
    }
    private void loadCustomerTable(ArrayList<Customer> customers) {
        Object[] columnCustomer={"id","name","type","phone","mail","address"};
        if (customers == null) {

            customers=this.customerController.findAll();
        }
        //TAblo Sıfırlama kısmı
        DefaultTableModel model = new DefaultTableModel(columnCustomer, 0);
        this.tbl_customer.setModel(model);

        // Veriyi ekle
        for (Customer customer : customers) {
            Object[] row = {
                    customer.getId(),
                    customer.getName(),
                    customer.getType().name(),
                    customer.getPhone(),
                    customer.getMail(),
                    customer.getAddress()
            };
            model.addRow(row);
        }

        // Sütun düzenlemeleri
        this.tbl_customer.getColumnModel().getColumn(0).setPreferredWidth(50); // ID sütunu genişliği
        this.tbl_customer.setEnabled(true);
    }
}
