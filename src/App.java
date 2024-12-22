<<<<<<< HEAD
import core.Database;
import core.Helper;
=======
import business.UserController;
import core.Database;
import core.Helper;
import entity.User;
import view.DashboardUI;
>>>>>>> b7fe936 (first commit)
import view.LoginUI;

import java.sql.Connection;


public class App {
    public static void main(String[] args){
        Helper.setTheme();
<<<<<<< HEAD
        LoginUI loginUI = new LoginUI();
=======
        UserController userController = new UserController();
        User user=userController.findByLogin("aise@gmail.com","123123");
        DashboardUI dashboardUI=new DashboardUI(user);
        //LoginUI loginUI = new LoginUI();
>>>>>>> b7fe936 (first commit)


    }

}
