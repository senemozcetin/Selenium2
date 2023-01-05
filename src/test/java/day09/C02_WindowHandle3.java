package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {
    @Test
    public void test01(){

        //1. TechPro education sayfasinin title'inin "Techpro Education" metnini icerdigini test edin.
        driver.get("https://www.techproeducation.com");
        String techproHandle=driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));


        //2. Yeni bir pencerede Amazon sayfasini acip title'in "Amazon" metnini icerdigini test edin.
        waitFor(4);
        driver.switchTo().newWindow(WindowType.WINDOW); // 1)YENI WINDOW OLUSTURUR 2)ORAYA GECIS YAPAR
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //3. Yeni bir pencerede LinkedIn sayfasini acip title'in "LinkedIn" metnini icerdigini test edin.
        waitFor(4);
        driver.switchTo().newWindow(WindowType.WINDOW); // 1)YENI WINDOW OLUSTURUR 2)ORAYA GECIS YAPAR
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        waitFor(3);
        //DRIVER NERDE? LINKEDINDE
        //TECPRO SAYFASINA GITMEK ICIN TEKRAR driver.switchTo().window(techprohandle)
        driver.switchTo().window(techproHandle);
        //DRIVER NERDE? TECHPRODA
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        waitFor(3);
    }
}
