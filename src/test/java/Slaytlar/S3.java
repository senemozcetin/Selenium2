package Slaytlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S3 {
    /*
        1. Yeni bir Class olusturalim.C06_ManageWindow
        2. Amazon soyfasina gidelim. https://www.amazon.com/
        3. Sayfanin konumunu ve boyutlarini yazdirin
        4. Sayfayi simge durumuna getirin
        5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        7. Sayfayi fullscreen yapin
        8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        9. Sayfayi kapatin

     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get(" https://www.amazon.com/");
        System.out.println("Konumu = " + driver.manage().window().getPosition());
        System.out.println("Boyut = " + driver.manage().window().getSize());
        driver.manage().window().minimize();
        Thread.sleep(3000);
        driver.manage().window().fullscreen();
        System.out.println("Konumu = " + driver.manage().window().getPosition());
        System.out.println("Boyut = " + driver.manage().window().getSize());

    }
}
