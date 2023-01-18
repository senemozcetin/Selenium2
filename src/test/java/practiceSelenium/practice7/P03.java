package practiceSelenium.practice7;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class P03 extends TestBase {
    @Test
    public void test01() {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions= new Actions(driver);
        WebElement browser=driver.findElement(By.xpath("//*[@aria-controls='supported-browsers']"));
        actions.scrollToElement(browser).perform();

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("//*[text()='ChromeDriver 109.0.5414.74']")).click();

        //Açılan pencerede chromedriver'i indirelim
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));

        //Driver'in indiğini doğrulayalım
        driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();
        waitFor(4);
        String pathFile="C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (2).zip";
        boolean downloadedFile= Files.exists(Paths.get(pathFile));
        // Files class indan paths.get methoduyla o dosyayoluna path e ait dosya var mi diye kontrol et. Bize boolean return eder
        Assert.assertTrue(downloadedFile);

    }
}
