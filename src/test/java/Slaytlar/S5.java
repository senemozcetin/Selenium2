package Slaytlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S5 {
    /*
    1.Yeni bir class olusturalim (Homework)
    2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
    oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
    3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
    yazdirin.
    4.https://www.walmart.com/ sayfasina gidin.
    5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
    6. Tekrar “facebook” sayfasina donun
    7. Sayfayi yenileyin
    8.Sayfayi tam sayfa (maximize) yapin
    9.Browser’i kapatin

     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.facebook.com");
        String actualTitle= driver.getTitle();
        String expectedTitle= "facebook";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else{
            driver.getTitle();
        }
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl= "facebook";
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Test PASSED");
        }else {
            driver.getCurrentUrl();
        }

        driver.get("https://www.walmart.com/");
        String actualTitleWalmart= driver.getTitle();
        String expectedTitleWalmart="Walmart.com";
        if (actualUrl.contains(expectedTitleWalmart)) {
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.close();

    }
}
