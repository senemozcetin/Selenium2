package homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07 {

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
        //driver.close();
    }
    @Test
    public void test01(){
         /*
    ~ http://tutorialsninja.com/demo/index.php?route=common/home adresine gidin
    ~ Telefonlar ve PDA'lar üzerine tıklayın
    ~ telefonların marka adını alın
    ~ tüm elemanlar için ekle düğmesine tıklayın
    ~ siyah toplam sepet eklendi düğmesine tıklayın
    ~ sepetten liste adlarını alın
    ~ görüntüleme listesi ve sepet listesindeki adları karşılaştırın
     */
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();


    }
}
