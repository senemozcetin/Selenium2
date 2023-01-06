package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {

    @Test
    public void test01() {

        //https://techproeducation.com a git
        driver.get("https://techproeducation.com");

        //Sayfanin altına doğru gidelim
        Actions actions = new Actions(driver);
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();

        //ARROW_DOWN PAGE_DOWN DAHA AZ MESAFE ALDIRIR. ARROW_DOWN oklarla asagi indir
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        waitFor(3);

        //Sonra sayfanin ustune dogru gidelim
        //YUKARI CIK PAGE_UP
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(3);

        //YUKARI CIK ARROW_UP
        actions.sendKeys(Keys.ARROW_UP).perform();
        waitFor(3);


    }
}
