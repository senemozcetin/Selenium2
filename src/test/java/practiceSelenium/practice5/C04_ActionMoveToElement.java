package practiceSelenium.practice5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C04_ActionMoveToElement extends TestBase {
    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String window1= driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
        WebElement dilSecenek= driver.findElement(By.xpath("//*[@class='icp-nav-link-inner']"));
        actions.moveToElement(dilSecenek).perform();
        waitFor(2);

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//*[text()='Change country/region.'])[1]")).click();
        waitFor(2);

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm= driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        driver.findElement(By.xpath("//*[text()='Changing country/region website']")).click();
        waitFor(2);

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@class='a-button-input']")).click();
        waitFor(2);

        // acilan yeni sayfanin Title'inin Elektronik icerdigini test ediniz
        Set<String> handles= driver.getWindowHandles();
        String window2="";
        for (String w:handles){
            if (!w.equals(window1)){
                window2=w;
            }
        }
        driver.switchTo().window(window2);
        Assert.assertTrue(driver.getTitle().contains("Elektronik"));

    }
}
