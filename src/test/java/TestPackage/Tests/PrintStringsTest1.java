package TestPackage.Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//@Listeners(Listener.class)
public class PrintStringsTest1 {

    @Test(groups = {"set1","set2"},dependsOnMethods = {"longTest1","mediumTest1"})
    @Parameters({"a","b"})
    public void shortTest1(int a , int b){
        System.out.println("Short : "+(a+b));
    }

    @Test(groups = {"set2"})
    //@Test(enabled=false)
    public void shortTest2(){
        System.out.println("Short : 22");
    }

    @Test(groups = {"set1"})
    public void longTest1(){
        System.out.println("Long : 111-111-111-111");
    }

    @Test(groups = {"set1","set2"})
    public void mediumTest1(){
        Assert.assertTrue(false);
        System.out.println("Medium : 111-111");
    }

    @Test(groups = {"set2"})
    public void mediumTest2(){
        System.out.println("Medium : 222-222");
    }

}
