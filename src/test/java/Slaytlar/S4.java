package Slaytlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S4 {
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
    public void test01(){

        driver.get("https://www.amazon.com/");

        System.out.println("Sayfanin konumu : "+ driver.manage().window().getPosition());
        System.out.println("Sayfanin size i : "+ driver.manage().window().getSize());

        driver.manage().window().setSize(new Dimension(600,600));
        driver.manage().window().setPosition(new Point(50,50));

        System.out.println("Sayfanin yeni size i : "+driver.manage().window().getSize());
        System.out.println("Sayfanin yeni konumu : "+ driver.manage().window().getPosition());

        Dimension actuelYeniSiza= driver.manage().window().getSize();
        if (actuelYeniSiza.getWidth()==600 && actuelYeniSiza.getHeight()==600){
            System.out.println("Size testi PASSED");
        }else System.out.println("Size testi FAILED");

        Point actuelYeniKonum = driver.manage().window().getPosition();
        if (actuelYeniKonum.getX()==50 && actuelYeniKonum.getY()==50 ){
            System.out.println("Konum testi PASSED");
        }else System.out.println("Konum testi FAILED");

    }
}
