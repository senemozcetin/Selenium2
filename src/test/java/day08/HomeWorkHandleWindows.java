package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class HomeWorkHandleWindows extends TestBase {
    //https://testcenter.techproeducation.com/index.php?page=multiple-windows
    //Title in ‘Windows’ oldugunu test edin
    //Click here a tiklayin
    //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String actualTitle=  driver.getTitle();
        Assert.assertEquals("Windows",actualTitle);
        //driver.findElement(By.xpath("//*[.='Click Here']"));
        driver.findElement(By.linkText("Click Here")).click();

        String window1 = driver.getWindowHandle();

        Set<String> allWindowHandles= driver.getWindowHandles();
        for (String w:allWindowHandles){
            if (!w.equals(window1)){
                driver.switchTo().window(w);
            }
        }
        Assert.assertEquals("New Window",driver.getTitle());













//        String actualTitle= driver.getTitle();
//        Assert.assertEquals("Windows",actualTitle);
//        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
//        String window01Handle=  driver.getWindowHandle();
//        Set<String> handles= driver.getWindowHandles();
//        for (String eachHandles: handles){
//            if (!eachHandles.equals(window01Handle)){
//                driver.switchTo().window(eachHandles);
//            }
//        }
//        Thread.sleep(3000);
//        String window02Title= driver.getTitle();
//        Assert.assertEquals("New Window",window02Title);


    }
}
