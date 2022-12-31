package Slaytlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S7 {
/*
1. Bir class oluşturun : AmazonSearchTest
2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
a.web sayfasına gidin. https://www.amazon.com/
b. Search(ara) “city bike”
c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.


 */
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://www.amazon.com/");
    WebElement search= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
    search.sendKeys("city bike"+ Keys.ENTER);
    WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
    String[] arr= sonucYazisiElementi.getText().split(" ");
    System.out.println(arr[2]);
    driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[1]")).click();
    driver.close();


}
}
