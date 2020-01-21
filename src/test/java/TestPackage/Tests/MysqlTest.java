package TestPackage.Tests;

import TestPackage.Utils.MysqlConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class MysqlTest {

    public static Logger log = LogManager.getLogger(MysqlTest.class);

    @Test(groups = {"database"},dataProvider = "getData")
    public void addNumbers(int a,int b) {
        log.info("-------inside addNumbers-----------");
        System.out.println(a+" + "+b+" = "+a+b);
    }

    @DataProvider
    public Iterator<Object[]> getData() throws SQLException {

        //Create iterator for Arraylist returned by getMySqlData method()
        //iterator will pass each data tuple of the list per test execution.
        //NOTE : number of elements in each array tuple should equal number of args in data receiver(addNumbers)

        ArrayList<Object[]> mysqlData = getMySqlData();
        Iterator<Object[]> it = mysqlData.iterator();

        return it;
    }

    public ArrayList<Object[]> getMySqlData() throws SQLException{

        log.warn("---------creating external connection------------");
        //Initiate Connection
        MysqlConnector connector = new MysqlConnector();
        Connection conn = connector.getConnector();

        //Prepare Query
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from numbers");

        //Collect query result in list of obj array

        //Ex :    list(0)  --->    [     3     ][     5       ]
        //        list(1)  --->    [     2     ][     6       ]
        //        list(2)  --->    [     8     ][     7       ]
        //        list(3)  --->    [     0     ][     4       ]
        ArrayList<Object[]> list = new ArrayList<Object[]>();

        while(rs.next()){
            Integer myInts[] = {rs.getInt(1),rs.getInt(2)};
            list.add(myInts);
        }

        //Terminate connection
        conn.close();

        return list;
    }

}
