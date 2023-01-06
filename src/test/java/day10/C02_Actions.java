package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {
    @Test
    public void test01(){
        /*
MANUAL:
1. Amazon home sayfasina git
2. Account & list e uzerinde bekle
3.Acilan pencerede Account linkine tokla
4.Acilan sayfanin Title inin, your Account oldugunu dogrula
 */


        //Method : hoverOver() and test the following scenario:
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // 1-ACTION OBJESI OLUSTUR
        Actions actions=new Actions(driver);

        // 2-ELEMANI BUL
        WebElement accountList= driver.findElement(By.id("nav-link-accountList"));

        // 2-UYGUN ACTIONS METHODUNU KULLAN. EN SONRA PERFORM KULLANMAYI UNUTMA
        //Sag ust bolumde bulunan “Account & Lists” menüsüne git
        actions.moveToElement(accountList).perform();
        waitFor(3);

        //“Account” secenegine tikka
        driver.findElement(By.linkText("Account")).click();


        //Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}
