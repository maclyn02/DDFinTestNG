import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//@Listeners(Listener.class)
public class test1 {

    @Test(groups = {"set1","set2"},dependsOnMethods = {"mytest111","mytest11"})
    @Parameters({"a","b"})
    public void mytest1(int a , int b){
        System.out.println(a+b);
    }

    @Test(groups = {"set2"})
    //@Test(enabled=false)
    public void mytest2(){
        System.out.println("Hello 222");
    }

    @Test(groups = {"set2"})
    public void mytest111(){
        System.out.println("Hello 111 111");
    }

    @Test(groups = {"set1","set2"})
    public void mytest11(){
        Assert.assertTrue(false);
        System.out.println("Hello 111 111");
    }

    @Test(groups = {"set2"})
    public void mytest12(){
        System.out.println("Hello 222 222");
    }

}
