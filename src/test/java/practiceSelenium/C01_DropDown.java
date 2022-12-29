package practiceSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
       // driver.close();
    }
    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement ddm= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        String sectigimOptionIdx= select.getFirstSelectedOption().getText();
        System.out.println("sectigimOptionIdx = " + sectigimOptionIdx);

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
       select.selectByValue("2");
       String sectigimOptionValue= select.getFirstSelectedOption().getText();
        System.out.println("sectigimOptionValue = " + sectigimOptionValue);

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
        String sectigimOptionText= select.getFirstSelectedOption().getText();
        System.out.println("sectigimOptionText = " + sectigimOptionText);

        // Tüm option'ları yazdırın
        List<WebElement> tumOptions=select.getOptions();
        int sayac=1;
       for (WebElement w:tumOptions){
           System.out.println(w.getText());
           sayac++;
       }

        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int expectedOptions=3;
        int actualOptions= tumOptions.size();
        Assert.assertEquals(expectedOptions,actualOptions);



    }
}
