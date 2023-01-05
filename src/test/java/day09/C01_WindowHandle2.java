package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String anaText= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",anaText);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        String window1Handle= driver.getWindowHandle();

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        waitFor(3);

        //2.PENCERE ACILIR VE 2.PENCEREDE ISLEM YAPMAK ISTEDIGIMDEN , O PENCEREYE SWITCH-GECIS YAPMALIYIZ.
        switchToWindow(1);//2.windowa gecis yaptik.Driver artik 2.window da

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualWindow2Title= driver.getTitle();
        String expectedWindow2Title= "New Window";
        Assert.assertEquals(expectedWindow2Title,actualWindow2Title);



    }
}
