import org.testng.annotations.Test;

public class test2 {

    @Test(groups = {"set1","set2"})
    public void mytest3(){
        System.out.println("Hello 333");
    }

    @Test
    public void mytest4(){
        System.out.println("Hello 444");
    }

}
