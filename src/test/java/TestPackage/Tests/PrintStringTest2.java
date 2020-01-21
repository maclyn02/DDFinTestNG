package TestPackage.Tests;

import org.testng.annotations.Test;

public class PrintStringTest2 {

    @Test(groups = {"set1","set2"})
    public void printSmallHello(){
        System.out.println("hello from class 2");
    }

    @Test
    public void printBigHello(){
        System.out.println("HELLO from class 2");
    }

}
