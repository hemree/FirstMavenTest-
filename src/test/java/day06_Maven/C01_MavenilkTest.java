package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class C01_MavenilkTest {
    /*
    1https://www.amazon.com/ sayfasına gidelim
2Arama kutusunu locate edelim
3“Samsung headphones” ile arama yapalım
4Bulunan sonuç sayısını yazdıralım
5İlk ürünü tıklayalım
6Sayfadaki tüm başlıkları yazdıralım
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        https://www.amazon.com/ sayfasına gidelim
        driver.get("https://www.amazon.com/");

//        Arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

//        “Samsung headphones” ile arama yapalım
        aramaKutusu.sendKeys("Samsung headphones");
        aramaKutusu.submit();//Enter'a bastık

//        Bulunan sonuç yazısı yazdıralım
        WebElement aramaSonucu = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println("aramaSonucu = " + aramaSonucu.getText());

//        İlk ürünü tıklayalım
        //Tüm arama sonucu ürünleri list içini koyup ilk elemanı tıklıyoruz
        List<WebElement> urunlistesi = driver.findElements(By.xpath("//img[@class='s-image']"));
        urunlistesi.get(0).click();

//        Sayfadaki tüm başlıkları yazdıralım
        List<WebElement> basliklar = driver.findElements(By.xpath("//h1"));
        basliklar.forEach(t -> System.out.println(t.getText()));






    }
}
