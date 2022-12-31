package Slaytlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S8 {
    //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    //2- Add Element butonuna basin
    //3 Delete butonu’nun gorunur oldugunu test edin
    //4 Delete tusuna basin
    //5 “Add/Remove Elements” yazisinin gorunur oldugunu test edin

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        Thread.sleep(3000);

        WebElement deleteButton= driver.findElement(By.xpath("//button[@class='added-manually']"));
        if (deleteButton.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");
        deleteButton.click();

        WebElement baslik =driver.findElement(By.xpath("//h3"));
        if (baslik.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        driver.close();


    }
}
