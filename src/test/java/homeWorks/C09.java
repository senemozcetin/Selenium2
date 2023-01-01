package homeWorks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C09 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //   go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
        driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
        Thread.sleep(3000);

        //Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Alert mesaji : "+ alertMessage);
        driver.switchTo().alert().accept();

        //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();

        //    cancel Alert  (Press a Button !)
        //Alert'ü kapatın
        driver.switchTo().alert().dismiss();


        //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();


        //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
        driver.switchTo().alert().sendKeys("Senem");
        driver.switchTo().alert().accept();

        //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
        String textMessage= driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        Assert.assertTrue(textMessage.contains("Senem"));

    }


}
