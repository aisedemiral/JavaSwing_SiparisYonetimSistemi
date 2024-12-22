package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance=null;
    private Connection connection=null;
    private final String DB_URL = "jdbc:sqlserver://localhost:1401;database=DbSiparisYonetimSistemi;encrypt=true;trustServerCertificate=true";
    private final String DB_USERNAME = "sa";
    private final String DB_PASSWORD = "YourSTRONG!Passw0rd";
    private Database(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           this.connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            System.out.println("Bağlantı başarılı!");
        }
        catch (ClassNotFoundException e) {
            System.out.println("SQL Server JDBC driver bulunamadı.");
            e.printStackTrace();
        }
        catch (SQLException e) {
            System.out.println("Veritabanı bağlantısı hatası: " + e.getMessage());
            e.printStackTrace();
        }

    }
    private Connection getConnection() {
        return connection;
    }

    public static Connection getInstance(){
        try {
            if (instance==null||instance.getConnection().isClosed()){
                instance=new Database();
            }
        } catch (SQLException expetion) {
            expetion.printStackTrace();        }
        return instance.getConnection();
    }

}
