package homeWorks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class S12 extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        //Yeni bir class olusturun: WindowHandle
        // ● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");


        // ● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandle= driver.getWindowHandle();


        // ● Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));


        // ● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).navigate().to("https://techproeducation.com");
        Thread.sleep(3000);


        // ● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actualTitleTech= driver.getTitle();
        Assert.assertFalse(actualTitleTech.contains("TECHPROEDUCATION"));
        Thread.sleep(3000);


        // ● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).navigate().to("https://www.walmart.com");
        Thread.sleep(3000);


        // ● Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));
        Thread.sleep(3000);

        // ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        String actualTitle2= driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));






    }
}
