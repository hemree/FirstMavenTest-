package day11_Iframe_Window_Handle;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C02_Window_Handle extends TestBase {

    @Test
    public void windowhandle() {
        // window 1 'de https://techproeducation.com adresine gidin.
            driver.get("https://techproeducation.com");

        // baslıgın "Techpro Education" oldugunu dogrulayın
        String actual = driver.getTitle();
        String expected = "Techpro Education | Online It Cources & Bootcamps";
        Assert.assertFalse(actual.contentEquals(expected));

        // window 2 de youtube u acın.
        driver.get("https://youtube.com");
        String youtube = driver.getWindowHandle();

        // window3 de linkedn i acın
        driver.get("https://tr.linkedin.com/");
        String linkedn = driver.getWindowHandle();


        //youtube sayfasina geciniz.
        wait(3);
        driver.switchTo().window(youtube);

        // linkedn sayfasina geciniz.
        wait(3);
        driver.switchTo().window(linkedn);




    }
}
