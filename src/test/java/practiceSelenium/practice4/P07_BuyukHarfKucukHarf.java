package practiceSelenium.practice4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P07_BuyukHarfKucukHarf extends TestBase {

    @Test
    public void test01() {
        //google sayfasina gidelim
        driver.get("https://www.google.com");
        //buyuk kucuk harf olacak sekilde Hello yazdiralim
        WebElement searchbox = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchbox.sendKeys(Keys.SHIFT, "h", Keys.SHIFT, "e", Keys.SHIFT, "l", Keys.SHIFT, "l", Keys.SHIFT, "o");
    }
}
