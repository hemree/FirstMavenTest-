package day08_Assertion_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Assertion {


    /*
    https://amazon.com adresine gidin.
    asagıdaki adları kullanarak 4 test metodu olusturun ve gerekli testleri yapın

    title test--sayfa basıgının amazon kelimesini icerip icermedigini test edin
    image test--amazon resminin görüntülendigini test edin
    search box--erisilebilir oldugunu test edin
    wrongtitletest-- sayfa baslıgının amazon icermedigini dogrulayın
     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();

    }

    @Test
    // Sayfa baslıgının amazon icerip icermedigini test edin.
    public void titletest() {
        String actualtitle = driver.getTitle();
        String exptectedtitle = "Amazon";
        Assert.assertTrue(actualtitle.contains(exptectedtitle));

    }

    @Test
    //amazon resminin görüntülendigini test edin
    public void imagetest() {
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    //erisilebilir oldugunu test edin
    public void searchBox() {
        WebElement seachbox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(seachbox.isEnabled());
    }

    @Test
    //sayfa baslıgının amazon icermedigini dogrulayın
    public void wrongTitleTest() {
        Assert.assertFalse(driver.getTitle().contains("amazon"));


    }
}
