package day17;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_JSExecuter_Click extends TestBase {
    @Test
    public void clickByJSTest() {
        /*
        clickByJSTest
        Techpro education ana sayfasina git
        LMS LOGIN elementine tikla
        Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et
         */

        driver.get("https://lms.techproeducation.com/");

        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));
        Assert.assertEquals("https://lms.techproeducation.com/",driver.getCurrentUrl());
    }
}
