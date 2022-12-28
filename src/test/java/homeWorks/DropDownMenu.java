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

public class DropDownMenu {
    /*
    amazon'a gidip dropdown'dan baby secenegini secip
    Java aratalim ve arama sonuc yazisinin Java icerdigini test edelim
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
        driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement dropdownMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdownMenu);
        select.selectByVisibleText("Baby");
        //select.selectByIndex(3);
        //select.selectByValue("search-alias=baby-products-intl-ship");

        //arama kutusuna Java yazdiralim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiText= sonucYazisiElementi.getText();
        String arananKelime="Java";
        Assert.assertTrue(sonucYazisiText.contains(arananKelime));
    }
}
