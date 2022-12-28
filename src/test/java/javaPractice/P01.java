package javaPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {
    /*
    -"amazon.com" adresine gidelim
    -bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
    -title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
    -Ardindan "trendyol.com" adresine gidelim
    -bu adresin basligini alalim ve "Sitesi" kelimesini icerip icermedigini kontrol edelim
    -Bi onceki web sayfamiza geri donelim
    -sayfayi yenileyelim
    -Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        String actuelTitle= driver.getTitle();
        String actuelUrl= driver.getCurrentUrl();
        System.out.println("Sayfa basligi : "+actuelTitle);
        System.out.println("Sayfa Url : "+actuelUrl);
        Assert.assertFalse(actuelTitle.contains("spend")&& actuelUrl.contains("spend"));
        driver.get("https://trendyol.com");
        String actuelTitleTrendyol = driver.getTitle();
        Assert.assertTrue(actuelTitleTrendyol.contains("Sitesi"));
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.quit();

    }
}
