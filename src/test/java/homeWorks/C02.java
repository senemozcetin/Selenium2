package homeWorks;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-Test01 isimli bir class olusturun
        //2- https://www.amazon.com/ adresine gidin
        driver.get(" https://www.amazon.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5-”Salesforce Apex Questions Bank” icin arama yapiniz
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Salesforce Apex Questions Bank"+ Keys.ENTER);

        //6- Kac sonuc bulundugunu yaziniz
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[text()='4 results for']"));
        String[] str= sonucYazisi.getText().split(" ");
        String result= str[0];
        int sonucSayisi= Integer.parseInt(result);
        System.out.println("Sonuc sayisi : "+sonucSayisi);

        //7-Sayfayi kapatin
        driver.close();
    }
}
