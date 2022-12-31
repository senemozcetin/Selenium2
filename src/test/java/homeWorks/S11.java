package homeWorks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class S11 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //  url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");


        //       ilk pencereyi al
        String window01= driver.getWindowHandle();

        //       "Click Here" butonuna tıklayın
        driver.findElement(By.linkText("Click Here")).click();

        //       setteki tüm pencereyi al
        Set<String> allWindowHandles= driver.getWindowHandles();

        //       diğer pencereye geç
        for (String w: allWindowHandles){
            if (!w.contains(window01)){
                driver.switchTo().window(w);
            }
        }

        //       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.xpath("//*[@name='emailid']")).sendKeys("somepne@gmail.com");


        //       Gönder düğmesine tıklayarak
        driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
        Thread.sleep(3000);


        //       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String actuelText= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("This access is valid only for 20 days.",actuelText);
        Thread.sleep(3000);

        //       Tekrar ilk pencereye geç
        driver.switchTo().window(window01);
        Thread.sleep(3000);

        //       İlk pencerede olduğunu doğrula
       Assert.assertEquals(window01,driver.getWindowHandle()); // url ile de test edilebilir.

        //String actualResult = driver.getCurrentUrl();
        // assertEquals("PASSED","https://demo.guru99.com/popup.php",actualResult);

    }


}
