package practiceSelenium.practice6;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.TestBase;

import java.time.Duration;

public class P05 extends TestBase {
  //https://chercher.tech/ptactice/explicit-wait-sample-selenium-webdriver sayfasina gidelim
    @Test
    public void test01(){
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

  //Click me, to open an ... butonuna basalim
        WebElement waitButton= driver.findElement(By.xpath("//*[@id='alert']"));
        waitButton.click();

        FluentWait<WebDriver> wait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))   // max bekleme  suresi
                .pollingEvery(Duration.ofSeconds(2));  // Hangi araliklarla beklemesi gerektigini belirleriz
        wait.until(ExpectedConditions.alertIsPresent()); //Alert cikana kadar bekle

        //Cikan alert i kapatalim
        driver.switchTo().alert().accept();

    }
}
