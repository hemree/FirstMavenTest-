package Practice02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) throws InterruptedException {
        // sonuc sayısının 100000000  fazla oldugunu test edin
        // sayfayı kapatın


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        String GoogleTitle = driver.getTitle();

        if (GoogleTitle.contains("Google")){
            System.out.println("test PASSED");
        }else {
            System.out.println("test FAİLED");
        }
        Thread.sleep(2000);


        // arama cubuguna "Nutella" yazıp aratın
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella" + Keys.ENTER);


        // bulunan sonuc sayısını yazdırın
        WebElement sonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String arr[] =sonuc.getText().split(" ");
        String sonuc1 =arr[1];
        System.out.println(sonuc1);

        // sonuc sayısının 100000000  fazla oldugunu test edin
      String sonuc3 =   sonuc1.replaceAll("\\D","");
        System.out.println(sonuc3);
        if (Integer.parseInt(sonuc3)>100000000){
            System.out.println("sonuc passed");
        }else {
            System.out.println("sonuc failed");
        }


        // sayfayi kapatin
        driver.close();















    }
}
