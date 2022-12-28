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
import java.util.List;

public class Task12 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
         driver.close();
    }

    @Test
    public void task12() {
        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully //Anasayfanin basarili bir sekilde gorunur oldugunu dogrulayin
        WebElement img = driver.findElement(By.cssSelector("img[alt='Website for automation practice']"));
        Assert.assertTrue(img.isDisplayed());

        //4. Click 'Products' button // 'Products' butonuna tiklayin
        WebElement productsEl = driver.findElement(By.xpath("//a[@href='/products']"));
        productsEl.click();

        //5. Hover over first product and click 'Add to cart' // Ilk urunun uzerine gelin ve 'Add to cart' butonuna tiklayin
        WebElement ilkUrun = driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));
        ilkUrun.click();

        //6. Click 'Continue Shopping' button  // 'Continue Shopping' butonuna tiklayin
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();

        //7. Hover over second product and click 'Add to cart' //ikinci urunun uzerine gelin ve 'Add to cart' butonuna tiklayin
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();

        //8. Click 'View Cart' button  // 'View Cart' butonuna tiklayin
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();

        //9. Verify both products are added to Cart //Her iki urunun de sepete eklendigini dogrulayin
        WebElement ilkUrunSepette = driver.findElement(By.xpath("//tr[@id='product-1']"));
        WebElement ikinciUrunSepette = driver.findElement(By.xpath("//tr[@id='product-2']"));
        Assert.assertTrue(ilkUrunSepette.isDisplayed() && ikinciUrunSepette.isDisplayed());

        //10. Verify their prices, quantity and total price // Fiyatlarini, miktarini ve toplam fiyati dogrulayin
        List<WebElement> urun1 = driver.findElements(By.id("product-1"));
        System.out.println("Ürün 1");
        System.out.println("------------------------------------------------");
        for (WebElement each : urun1) {
            System.out.println(each.getText());
        }
        System.out.println("Ürün 2");
        System.out.println("------------------------------------------------");
        List<WebElement> urun2 = driver.findElements(By.id("product-2"));
        for (WebElement each : urun2) {
            System.out.println(each.getText());


        }

    }
}
