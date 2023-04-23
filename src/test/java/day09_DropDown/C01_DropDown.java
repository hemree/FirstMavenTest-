package day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C01_DropDown {
    /**
    -DropDown nedir? : Alt baslıkların oldugu acılır menu listesi.
    DropDown nasıl automate edilir? ( Handle) :
         a- DropDown menuyu ilk olarak locate ederiz.
         b- select objesi olustururuz.
         c-select objesinin dropdown  webelementi'nin icerigine ve seceneklerine erişim saglaması icin
         SELECT sınıfına arguman olarak locate ettiginiz webelemeti koyarız.
         SYNTAX : Select select = new Select(ddm Webelement)
         d- select class'ı, sadece <select> tagı ile olusturulmus dropdown menulere uygulanabilir.
         e-select objesiyle ddm'yü handle edebilmek icin 3 method kullanılır.
            -selectByVisibleText() = ddm deki elemente görünür metin ile ulasmak icin kullanılır.
            -SelectByİndex() = index ile ulasmak icin kullanılır
            -SelectByValue() = elementin degeri ile ulasmak ıcın kullanılır ( option daki degere ulasmak icin)

         f- getOptions() = Locate ettigimiz ddm'deki tüm secenekleri bize döndürür.
         g- getFirstSelectedOption() = Ddm'deki en son secili kalan ilk secenegi bize döndürür.
     */

static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }


    @Test
    public void test02() {
        List<WebElement> statelist = driver.findElements(By.tagName("select"));
        for (WebElement w: statelist){
            System.out.println(w.getText());
        }

        /**
         Select select;
        for (WebElement dropdown : allMultipleDropdowns) {
            select = new Select(dropdown);
            List<WebElement> options = select.getOptions();
            for (WebElement option : options) {
                //3. Select all the options from multiple select dropdown.
                option.click();
                //4. Print out all selected values.
               System.out.println(option.getText() + " option.isSelected()= " + option.isSelected());
               */
    }


    @AfterClass
    public static void afterClass() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
