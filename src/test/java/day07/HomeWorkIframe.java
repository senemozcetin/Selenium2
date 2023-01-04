package day07;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class HomeWorkIframe extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //Bir class olusturun: IframeOdev
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
       driver.get("https://the-internet.herokuapp.com/iframe");

        //sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        int iframeSize= iframeList.size();
        System.out.println("Toplam iframe sayisi = "+ iframeSize);

        //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String actualTitle= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(actualTitle.contains("Editor"));
        Thread.sleep(3000);

        //Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement paragrafYazisi= driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        paragrafYazisi.clear();
        Thread.sleep(3000);

        //Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        paragrafYazisi.sendKeys("iframein icindeyim");
        Thread.sleep(3000);

        //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim...

        driver.switchTo().parentFrame();
        String parentYazi= driver.findElement(By.xpath("//*[.='Elemental Selenium']")).getText();
        Assert.assertTrue(parentYazi.contains("Elemental Selenium"));

    }
}
