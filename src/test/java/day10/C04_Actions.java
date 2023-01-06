package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {
    @Test
    public void dragAndDropTest() {

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENTLERI IFRAME IN ICINDE
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)

        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        //DRAGANDDROP METHODU SURUKLEME ISLEMINI YAPAR
        Actions actions = new Actions(driver);
        actions.dragAndDrop(kaynak, hedef).perform();//KAYNAGI HEDEFE SURUKLE

    }

    @Test
    public void clickAndHoldTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENTLERI IFRAME IN ICINDE
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)

        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        //DRAGANDDROP() METHODU SURUKLEME ISLEMINI YAPAR
        Actions actions = new Actions(driver);
        actions.clickAndHold(kaynak) //kaynagi tut
                .moveToElement(hedef)//hedefe koy
                .release() //kaynagi birak
                .build()  //onceki methodlarin iliskisini kur/guclendir-- birbirine bagla. Kullanilmasi tercih edilir (sart degil)
                .perform(); //islemi gerceklestir -- build performdan once kullanilmalidir
    }

    @Test
    public void moveByOffSetTest() {
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));
//        dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions.
                clickAndHold(kaynak).//kaynagi tikla ve tut
                moveByOffset(430,30). //bu koordinatlara surukle
                release(). // birak
                build().//birbirine bagla
                perform();//islemi yap
    }
}