package TestPackage.Tests;

import TestPackage.Config;
import TestPackage.Utils.XLS_Reader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class DataViewerTest {

    @Test(dataProvider = "getData")
    public void test_method(String a, String b){

        Float num1=Float.parseFloat(a);
        Float num2=Float.parseFloat(b);
        int sum=Math.round(num1)+Math.round(num2);
        System.out.println(sum);
    }

    @DataProvider
    public Iterator<Object[]> getData(){
        ArrayList<Object[]> testdata=getExcelData();
        Iterator<Object[]> iterator = testdata.iterator();
        return iterator;
    }

    public ArrayList<Object[]> getExcelData(){

        ArrayList<Object[]> data=new ArrayList<Object[]>();

        XLS_Reader r = new XLS_Reader(Config.xlsFilePath);
        int rowCount = r.getRowCount("Sheet1");
        for(int i=2;i<=rowCount;i++)
        {
            String col1=r.getCellData("Sheet1","num1",i);
            String col2=r.getCellData("Sheet1","num2",i);

            Object dataArray[]={col1,col2};
            data.add(dataArray);
        }
        return data;
    }
}
