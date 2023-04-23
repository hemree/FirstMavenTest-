package day09_DropDown;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C02_TestBaseDemo extends TestBase {
    @Test
    public void test01() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        // baslıgın bootcamp icerdigini test edelim.
        String actual = driver.getTitle();
        String expected = "Bootcamp";
        Assert.assertTrue(actual.contains(expected));
    }
}
