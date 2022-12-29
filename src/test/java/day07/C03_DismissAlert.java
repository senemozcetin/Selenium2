package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {
    // Bir metod olusturun: dismissAlert
    //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin.
    @Test
            public void test01(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult ="You clicked: Cancel";
        Assert.assertEquals(actualResult,expectedResult);
    }


}
