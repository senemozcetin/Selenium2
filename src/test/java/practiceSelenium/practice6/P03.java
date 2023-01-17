package practiceSelenium.practice6;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class P03 extends TestBase {
    @Test
    public void test01() {
        /*
                               - FAKER -
        Faker class'ı, adlar, telefon numaraları, adresler, SSN vb.
    gibi gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.
    Web uygulamanızın bunları doğru bir şekilde kaydedeceğini bildiğiniz sürece,
    çoğu zaman ad veya adres gibi bu değerlerin ne olduğu umurunuzda olmaz ve faker kullanmak
    bu verileri modellemenize ve bu alanlar için şimdiye kadar test çalıştırması için yeni dinamik
    değerler oluşturmanıza olanak tanır.
        Faker class'ını kullanabilmemiz için mvn repository adresinden java faker kütüphanesini
    projemize eklememiz gerekmektedir.
     */
        //"https://demoqa.com/automation-practice-form"  Adresine gidin
        driver.get("https://demoqa.com/automation-practice-form");

        // Formu doldurunuz
        WebElement firstName= driver.findElement(By.xpath("//*[@id='firstName']"));
        Faker faker=new Faker();
        firstName.sendKeys(faker.name().firstName()+ Keys.TAB,faker.name().lastName(),Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,Keys.ARROW_RIGHT,Keys.TAB,faker.phoneNumber().cellPhone(),
                Keys.TAB,"20 Jul 1980",Keys.ENTER,Keys.TAB);
        WebElement subject= driver.findElement(By.id("subjectsInput"));
        subject.sendKeys("Maths");
        subject.sendKeys(Keys.ENTER,Keys.TAB,Keys.TAB,Keys.SPACE);
        WebElement dosya= driver.findElement(By.xpath("//*[@id='uploadPicture']"));
        dosya.sendKeys("C:\\Users\\Lenovo\\Downloads\\dummy.txt");
        WebElement yaziAlani=driver.findElement(By.xpath("//*[@id='currentAddress']"));
        yaziAlani.sendKeys(faker.address().fullAddress());

        WebElement ddm= driver.findElement(By.xpath("//*[text()='Select State']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("NCR");
        WebElement city= driver.findElement(By.xpath("//*[text()='Select City']"));
        select.selectByVisibleText("Delhi");



    }
}
