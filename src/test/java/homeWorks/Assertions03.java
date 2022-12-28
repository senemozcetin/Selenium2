package homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assertions03 {

    //https://www.bestbuy.com/ adresine gidin farkli test methodlari
    // olusturarak asagidaki testleri yapin

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        //   i)Sayfa URL'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
        String expectedUrl= "https://www.bestbuy.com/";
        String actuelUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actuelUrl);
    }
    @Test
    public void test02(){
        //   ii)titleTest=> Sayfa basliginin "Rest" icermedigini(contains) test edin
        String istenmeyenKelime= "Rest";
        String actuelTitle= driver.getTitle();
        Assert.assertFalse(actuelTitle.contains(istenmeyenKelime));
    }
    @Test
    public void test03(){
        //   iii)logoTest=> BestBuy logosunun goruntulendigini test edin
        WebElement logo= driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test04(){
        //   iv)FrancaisLinkTest => Fransizca Linkin goruntulendigini test edin
        WebElement link= driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(link.isDisplayed());
    }
}
