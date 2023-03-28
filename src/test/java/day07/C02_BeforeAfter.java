package day07;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setup(){
        System.out.println("Her test methodu öncesi bir kez calisir");
    }
    @After
    public void teardown(){
        System.out.println("her test methodu sonrası bir kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");
    }
}
