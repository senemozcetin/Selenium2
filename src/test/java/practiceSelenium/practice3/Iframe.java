package practiceSelenium.practice3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Iframe extends TestBase {
    @Test
    public void test01() throws InterruptedException {
               //- https://html.com/tags/iframe/ adresine gidiniz
                   driver.get("https://html.com/tags/iframe/");
                  String ilksayfaHandle = driver.getWindowHandle();

               //    - youtube videosunu çalıştırınız
                WebElement iframe = driver.findElement(By.cssSelector("iframe[frameborder='0']"));
                driver.switchTo().frame(iframe);
                driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();


               //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
                 Thread.sleep(3000);
                 driver.navigate().refresh();

               //    - yeni sekmede amazon adresine gidiniz
                 driver.switchTo().newWindow(WindowType.TAB);
                 driver.get("https://www.amazon.com");

               //    - iphone aratınız
                  driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone"+ Keys.ENTER);

               //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String[] sonucyazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText().split(" ");
        System.out.println("Arama sonuc sayisi : " + sonucyazisi[2]);

               //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(ilksayfaHandle);
        String actualUrl= driver.getCurrentUrl();
        System.out.println(actualUrl);

               //    - ilk sekmeyi kapatalım
        driver.close();

               //    - Sonra diğer sekmeyide kapatalım

    }
}
