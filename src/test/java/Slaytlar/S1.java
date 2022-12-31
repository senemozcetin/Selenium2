package Slaytlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S1 {
               /*
            1. Yeni bir package olusturalim : day01
            2. Yeni bir class olusturalim : C03_GetMethods
            3. Amazon sayfasina gidelim. https://www.amazon.com/
            4. Sayfa basligini(title) yazdirin
            5. Sayfa basliginin “Amazon” icerdigini test edin
            6. Sayfa adresini(url) yazdirin
            7. Sayfa url’inin “amazon” icerdigini test edin.
            8. Sayfa handle degerini yazdirin
            9. Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
            10. Sayfayi kapatin.
                 */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" https://www.amazon.com/");
        String actualTitle= driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertTrue(actualTitle.contains("Amazon"));
        String actualUrl= driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        Assert.assertTrue(actualUrl.contains("amazon"));
        System.out.println(driver.getWindowHandle());
        String gateawayText= driver.getPageSource();
        Assert.assertTrue(gateawayText.contains("Gateway"));
        driver.close();


    }

}
