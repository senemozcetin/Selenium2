package practiceSelenium.practice4;

import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        /*
    http://uitestpractice.com/Students/Actions adresine gidelim
    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
    Accept ile alert'ü kapatalım
    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
     */
        // http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get(" http://uitestpractice.com/Students/Actions");

        //Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        WebElement maviKutu = driver.findElement(By.id("div2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(maviKutu).build().perform();

        Thread.sleep(3000);

        //Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement doubleclick = driver.findElement(By.xpath("//button[@ondblclick='myDblClickFunction()']"));
        actions.doubleClick(doubleclick).build().perform();

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        Assert.assertEquals(alertText, "Double Clicked !!");
        driver.switchTo().alert().accept();

        //Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef= driver.findElement(By.id("droppable"));
        actions.dragAndDrop(kaynak,hedef).build().perform();
       String dropText = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();

       Assert.assertEquals(dropText, "Dropped!");
    }
}
