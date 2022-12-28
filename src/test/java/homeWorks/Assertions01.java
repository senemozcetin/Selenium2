package homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assertions01 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        //Eger test methodumuzda hicbir test yoksa test calistiktan sonra hicbir
        //problemle karsilasilmadigini rporlamk icin TEST PASSED yazisi cikar

        //Eger testleri if ile yaparsak test FAILED olsa bile kodlar problemsiz
        //calistigi icin kod calismasi bittiginde ekranin sol alt kisminda TEST PASSED yazacaktir
        driver.get("https://www.amazon.com");

        //url'in https://www.facebook.com oldugunu test edin
        //if (driver.getCurrentUrl().equals("https://www.facebook.com")){
        //    System.out.println("Test PASSED");
        //}else System.out.println("Test FAILED");

        String expectedUrl= "https://www.facebook.com";
        String actuelUrl= driver.getCurrentUrl();
        Assert.assertEquals("Url beklenenden farkli",expectedUrl,actuelUrl);
    }
}
