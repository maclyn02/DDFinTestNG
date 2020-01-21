package TestPackage.Utils;

import java.sql.*;
import TestPackage.Config;

public class MysqlConnector {

    public Connection getConnector(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(Config.DB_URL, Config.DB_UNAME, Config.DB_PASSWORD);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
