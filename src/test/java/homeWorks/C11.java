package homeWorks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C11 extends TestBase {
    //
    //1. http://zero.webappsecurity.com sayfasina gidin
    //2. Signin buttonuna tiklayin
    //3. Login alanine  "username" yazdirin
    //4. Password alanine "password" yazdirin
    //5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
    //6. Online Banking menusunden Pay Bills sayfasina gidin
    //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
    //8. tarih kismina "2020-09-10" yazdirin
    //9. Pay buttonuna tiklayin
    //10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
    //

    @Test
    public void test01(){
        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();
        driver.findElement(By.cssSelector("input[id='user_login']")).sendKeys("username",Keys.TAB,
                "password",Keys.TAB,Keys.SPACE);
        driver.findElement(By.cssSelector("*[value='Sign in']")).click();
        driver.navigate().back();
        driver.findElement(By.cssSelector("[id='onlineBankingMenu']")).click();
        driver.findElement(By.cssSelector("[id='pay_bills_link']")).click();
        driver.findElement(By.cssSelector("[id='sp_amount']")).sendKeys("500",Keys.TAB,"2020-09-10");
        driver.findElement(By.cssSelector("[id='pay_saved_payees']")).click();
        String sonucYazisi= driver.findElement(By.cssSelector("[id='alert_content']")).getText();
        Assert.assertEquals("The payment was successfully submitted.",sonucYazisi);



    }
}
