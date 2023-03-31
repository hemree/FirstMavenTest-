package Practice02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");


        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        String actueltagname =  searchbox.getTagName();
        String expectedtagnme = "input";

        if (actueltagname.equals(expectedtagnme)){
            System.out.println("Test PASSED");
        }else
            System.out.println("Test FAİLED");


        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin

       String SearchAtt = searchbox.getAttribute("name");
       String expectedNameAtt = "field-keywords";

       if (SearchAtt.equals(expectedNameAtt)){
           System.out.println("FİELD-KEYWORDS İS PASSED");
       }else
           System.out.println("FİELD-KEYWORDS İS FAİLED");


        // sayfayi kapatiniz
        driver.close();













    }
}
