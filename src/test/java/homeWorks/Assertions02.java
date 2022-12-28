package homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assertions02 {

    /*
    Tek bir sayfada islem yapacagimiz icin ve gorevler birbirinin devami oldugu icin
    before yerine beforeClass kullanmam daha mantikli
     */


    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //3 farkli test methodu olusturarak asagidaki gorevleri yapin

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){

        //  i)Url'in amazon icerdigini test edin
        String arananKelime="amazon";
        String actuelUrl= driver.getCurrentUrl();
        Assert.assertTrue(actuelUrl.contains(arananKelime));
    }
    @Test
    public void test02(){
        //  ii)title'in facebook icermedigini test edin
        String istenmeyenKelime= "facebook";
        String actuelTitle= driver.getTitle();
        Assert.assertFalse(actuelTitle.contains(istenmeyenKelime));
    }
    @Test
    public void test03(){
        //  iii)sol ust kosede amazon logosunun gorundugunu test edin
        WebElement logo= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }
}
