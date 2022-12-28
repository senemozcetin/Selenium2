package homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        1-C01_TekrarTesti isimli bir class olusturun
//        2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

//        3- cookies uyarisini kabul ederek kapatin

//        4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actuelTitle= driver.getTitle();
        String expectedTitle= "Google";
        if (actuelTitle.contains(expectedTitle)){
            System.out.println("test PASSED");
        }else System.out.println("test FAILED");

//        5 Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

//        6 Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(sonucYazisi.getText());

//        7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        //Yaklaşık 149.000.000 sonuç bulundu (0,33 saniye)
        String[] myList = sonucYazisi.getText().split(" ");
        String sayi= myList[1];
        String yeniSayi= sayi.replace(".","");
        int enYeniSayi= Integer.parseInt(yeniSayi);
        System.out.println(enYeniSayi);

        if (enYeniSayi>10000000){
            System.out.println("Sonuc sayisi testi PASSED");
        }else System.out.println("Sonuc sayisi testi FAILED");

//        8 Sayfayi kapatin
        driver.close();

    }
}
