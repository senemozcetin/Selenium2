package homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandleDropdown {
    /*
    1. http://zero.webappsecurity.com/ Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password.” yazin
    5. Sign in tusuna basin
    6. Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. “amount” kutusuna bir sayi girin
   10. “US Dollars” in secilmedigini test edin
   11. “Selected currency” butonunu secin
   12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
   13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */
    WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public  void tearDown(){
        //driver.close();
    }
    @Test
    public void test01(){
        driver.get("http://zero.webappsecurity.com/");

        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        driver.findElement(By.xpath("(//*[@class='ui-state-default ui-corner-top'])[2]")).click();
        WebElement ddm=driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select= new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("500");
        WebElement button= driver.findElement(By.id("pc_inDollars_true"));
        if (!button.isSelected()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        driver.findElement(By.xpath("//*[@id='pc_inDollars_false']")).click();
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        driver.findElement(By.id("purchase_cash")).click();

        String actuelResult= driver.findElement(By.xpath("//*[@id='alert_content']")).getText();
        String expectedResult="Foreign currency cash was successfully purchased.";
        Assert.assertTrue(actuelResult.contains(expectedResult));

    }
}
