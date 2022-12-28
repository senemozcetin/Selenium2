package homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");


        //2. Username kutusuna "standard_user" yazdirin
        WebElement aramaKutusu= driver.findElement(By.cssSelector("*[id='user-name']"));
        aramaKutusu.sendKeys("standard_user"+ Keys.ENTER);

        //3. Password kutusuna "secret_sauce" yazdirin
         driver.findElement(By.cssSelector("*[id='password']")).sendKeys("secret_sauce"+ Keys.ENTER);

         //4. Login tusuna basin
        driver.findElement(By.cssSelector("*[id='login-button']")).click();

         //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement urunIsmi= driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        System.out.println("Urun ismi :"+urunIsmi.getText());
        urunIsmi.click();

         //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();


         //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[text()='1']")).click();

         //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement seciliUrun= driver.findElement(By.xpath("//*[@class='cart_item_label']"));
        if (seciliUrun.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

          //9. Sayfayi kapatin
        Thread.sleep(30000);
        driver.close();

    }
}
