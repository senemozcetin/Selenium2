package practiceSelenium.practice7;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P02 extends TestBase {
    @Test
    public void test01() {

        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz

//        String farkliKisim= System.getProperty("user.home");//C:\Users\Lenovo
//        String ortakKisim= "\\Downloads\\dummy.txt";
        String path="C:\\Users\\Lenovo\\Downloads\\\\dummy.txt";
        WebElement dosyaSec= driver.findElement(By.xpath("//*[@id='uploadfile_0']"));
        dosyaSec.sendKeys(path);

        // I accept terms of service bölümünü tikleyin
        driver.findElement(By.xpath("//*[@id='terms']")).click();

        // Submit File buttonuna basınız
        driver.findElement(By.xpath("//*[@id='submitbutton']")).click();

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='res']")).isDisplayed());
    }
}
