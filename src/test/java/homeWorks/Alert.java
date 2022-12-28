package homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alert {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //alert te ok tusuna basin
        driver.switchTo().alert().accept();

        //result kisminda "You successfully clicked an alert" yazisinin olup olmadigini test edin
        String expectedResult="You successfully clicked an alert";
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String actuelResultYazisi= sonucYazisiElementi.getText();
        Assert.assertEquals(expectedResult,actuelResultYazisi);




    }
    }

