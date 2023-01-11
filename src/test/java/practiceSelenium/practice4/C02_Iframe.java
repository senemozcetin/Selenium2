package practiceSelenium.practice4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void test01() {
        // ...Exercise 2...

        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        WebElement baslik = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslik.isEnabled());
        System.out.println(baslik);

        // TextBox'a 'Merhaba Dunya' yazin.
        WebElement iframe= driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame(iframe);
        WebElement text= driver.findElement(By.xpath("//*[@id='tinymce']"));
        text.clear();
        text.sendKeys("Merhaba Dunya");

        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
        driver.switchTo().parentFrame();
       Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText());
    }
}
