package homeWorks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Can02 extends TestBase {
    static List<WebElement> add;
    @Test
    public void test01() throws InterruptedException {
        /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list
     */
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        driver.findElement(By.linkText("Phones & PDAs")).click();
        List<WebElement>markalar= driver.findElements(By.xpath("//h4"));

        List<String> CartList =new ArrayList<>();
        for (int i = 0; i <markalar.size() ; i++) {
            CartList.add(i,markalar.get(i).getText());
            System.out.println(CartList.get(i));
        }
        System.out.println("---------------------------------");

        add = driver.findElements(By.xpath("//*[text()='Add to Cart']"));
        for(WebElement s :add) {
            s.click();
        }
        Thread.sleep(3000);
        driver.findElement(By.id("cart-total")).click();
       List<WebElement>karttakiMarkalar= driver.findElements(By.className("text-left"));
        List<String> CartList2 =new ArrayList<>();
        for (int i = 0; i <karttakiMarkalar.size() ; i++) {
            CartList.add(i,karttakiMarkalar.get(i).getText());
        }

       for (WebElement w:karttakiMarkalar){
           System.out.println(w.getText());
       }

       Assert.assertTrue(CartList.containsAll(CartList2));


    }

}
