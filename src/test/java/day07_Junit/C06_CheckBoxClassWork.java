package day07_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C06_CheckBoxClassWork {
static  WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }

    @Test
    public void checkbox() throws InterruptedException {
       // Verilen web sayfasına gidin.
       // https://the-internet.herokuapp.com/checkboxe

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // Checkbox1 ve checkbox2 elementlerini locate edin.

        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

       // Checkbox1 seçili değilse onay kutusunu tıklayın

        Thread.sleep(3000);
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
       // Checkbox2 seçili değilse onay kutusunu tıklayın

        Thread.sleep(3000);
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }

    }
}
