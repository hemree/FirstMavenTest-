package day08_Assertion_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {

    /*
    Given Kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    3 farklı test methodu oluşturalım.
    1.Method:
         a.Yil,ay,gün dropdown menuleri locate ediniz.
         b. Select objesi olustur.
         c. Select object'i kullanarak 3 farklı sekilde secim yapınız.

    2.Method:
         a. Tüm eyalet isimlerini yazdıralım

   // 3.Method:
       //  a. State dropdowndaki varsayilan secili secenegin 'select a state' oldugunu verify edelim.

     */

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    // a.Yil,ay,gün dropdown menuleri locate ediniz.
    // b. Select objesi olustur.
    // c. Select object'i kullanarak 3 farklı sekilde secim yapınız.
    public void TitleTest() {
        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
        Select select = new Select(year);
       // select.selectByIndex(28); bazen bu sekilde calismayabilir.
        year.sendKeys("1995");

        WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
        Select select1 = new Select(month);
        month.sendKeys("May");

        WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
        Select select3 = new Select(day);
        day.sendKeys("18");

    }

    @Test
    public void StateTest() {
       // 2.Method:
       // a. Tüm eyalet isimlerini yazdıralım
        WebElement allstates = driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(allstates);
        List<WebElement> statelist = select.getOptions();
        for (WebElement w: statelist){
            System.out.println(w.getText());
        }
       // statelist.stream().forEach(t-> System.out.println(t.getText()));  LAMBDA
    }

    @Test
    // 3.Method:
    //  a. State dropdowndaki varsayilan secili secenegin 'select a state' oldugunu verify edelim.
    public void StateDD() {
        WebElement allstates = driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(allstates);
        String lastjoicetext = select.getFirstSelectedOption().getText();
        // getFirstSelectOption = son secilen option'u verir.
        Assert.assertEquals("Select a State",lastjoicetext);
        System.out.println(lastjoicetext);

    }
}
