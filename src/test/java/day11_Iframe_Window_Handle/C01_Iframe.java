package day11_Iframe_Window_Handle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    @Test
    public void iframe() {

        //sayfaya gidiniz.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // kalın yazının "Editor" kelimesini icerdigini dogrulayın
        WebElement baslik = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslik.getText().contains("Editor"));

        // Textbox icindeki yaziyi siliniz.
        driver.switchTo().frame(0);
        WebElement textbox = driver.findElement(By.xpath("//p"));
        textbox.clear();//icindeki yaziyi siler.
        wait(2);

        // sildiginiz yazı yerine " Bu textbox iframe icinde yer almaktadır" yazdirin.
        textbox.sendKeys(" Bu textbox iFrame de yer almaktadir.");
        wait(2);

        // sayfadaki "Elemental Selenium" yazisinin görünür oldugunu dogrulayınız.
        driver.navigate().refresh();
        WebElement ESelenium = driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(ESelenium.isDisplayed());
    }
}
