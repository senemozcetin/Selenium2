package homeWorks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Can03 extends TestBase {
    @Test
    public void test01(){
        // Given kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net/");
        //    Then new butonuna basar
        driver.findElement(By.xpath("//*[@class='dt-button buttons-create']")).click();

        //    And editor firstname kutusuna "<firstName>" bilgileri girer
        //    And editor lastname kutusuna "<lastName>" bilgileri girer
        //    And editor position kutusuna "<position>" bilgileri girer
        //    And editor office kutusuna "<office>" bilgileri girer
        //    And editor extension kutusuna "<extension>" bilgileri girer
        //    And editor startdate kutusuna "<startDate>" bilgileri girer
        //    And editor salary kutusuna "<salary>" bilgileri girer
        //    When Create tusuna basar
        driver.findElement(By.xpath("//*[@id='DTE_Field_first_name']")).sendKeys("Senem",
                Keys.TAB,"Ozcetin",Keys.TAB,"QA",Keys.TAB,"Tester",Keys.TAB,"4",Keys.TAB,"2023-05-12",Keys.TAB,"120000",Keys.ENTER);

        //    Then Kullanıcının eklendiğini doğrular.
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Senem"+Keys.ENTER);
        String actuelIsim =driver.findElement(By.xpath("//*[@class='sorting_1']")).getText();
        Assert.assertTrue(actuelIsim.contains("Senem"));

        //    And Eklediği kullanıcı kaydını siler
        driver.findElement(By.xpath("//*[@class='sorting_1']")).click();
        driver.findElement(By.xpath("//*[@class='dt-button buttons-selected buttons-remove']")).click();

        //    Then Kullanıcinin silindiğini doğrular.
        driver.findElement(By.xpath("//button[@class='btn']")).click();
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[.='No matching records found']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());

    }


}
