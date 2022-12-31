package Slaytlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S6 {
    /*
    1. Yeni bir class olusturun (TekrarTesti)
    2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
    doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
    3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
    doğru URL'yi yazdırın.
    4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
    5. Youtube sayfasina geri donun
    6. Sayfayi yenileyin
    7. Amazon sayfasina donun
    8. Sayfayi tamsayfa yapin
    9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
    Yoksa doğru başlığı(Actual Title) yazdırın.
    10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
    URL'yi yazdırın
    11.Sayfayi kapatin

     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://youtube.com");
        String actuelTitle=driver.getTitle();
        if (actuelTitle.contains("youtube")){
            System.out.println("Test PASSED");
        }else {
            driver.getTitle();
        }
        String actualUrl= driver.getCurrentUrl();
        if (actuelTitle.contains("youtube")){
            System.out.println("Test PASSED");
        }else {
            driver.getCurrentUrl();
        }
        driver.get("https://www.amazon.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.manage().window().fullscreen();
        String amazonTitle=  driver.getTitle();
        if (amazonTitle.contains("Amazon")){
            System.out.println("Test PASSED");
        }else {
            driver.getTitle();
        }
        String amazonUrl= driver.getCurrentUrl();
        if (amazonUrl.contains("https://www.amazon.com/")){
            System.out.println("Test PASSED");
        }else {
            driver.getCurrentUrl();
        }
        driver.close();
    }

}
