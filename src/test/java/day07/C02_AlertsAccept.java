package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //Bir metod olusturun: acceptAlert
        //○1. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        // uyarıdaki OK butonuna tıklayın
        driver.
                switchTo().//degistir
                alert(). //alerte degistir
                accept(); //OK secenegine tiklanir

        //Result mesajının “You successfully clicked an alert” oldugunu test edin.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult= "You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);


        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    }

    /*
    Alertleri nasil automate edersin? How to handle alerts in selenium?
    -Alertler javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmemiz gerekir
     */

}
