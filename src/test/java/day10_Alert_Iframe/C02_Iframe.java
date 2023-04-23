package day10_Alert_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Iframe extends TestBase {


    @Test
    public void Iframe() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //-- ana sayfadaki "an iframe with a thin black border" metninde "black border" yazisinin oldugunu test edelim.
        String actual = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(actual.contains("black border"));

        driver.switchTo().frame(0);
       // -- ayrıca "Applications lists" yazisinin sayfada oldugunu test edelim
        String actual2 = driver.findElement(By.xpath("//*[text()='Applications lists']")).getText();
        Assert.assertTrue(actual2.contains("Applications lists"));

        //--son olarak footer daki "powered by" yazisini varlıgını test edin
        driver.switchTo().defaultContent();
        String actual3 = driver.findElement(By.xpath("//*[text()='Povered By']")).getText();
        Assert.assertTrue(actual3.contains("Povered By"));
    }
}

