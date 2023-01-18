package practiceSelenium.practice7;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P05 extends TestBase {
    @Test
    public void test01() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //Tüm sayfanın resmini alalım
        String tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));

        /*
FILEUTILS CLASS'I, FILE OBJECT'LERI ILE BIRLIKTE KULLANABILECEGIMIZ METHOD'LAR ICERIR.
BU METHOD'LARI KULLANARAK DOSYALARDA OKUMA, YAZMA VE KOPYALAMA ISLEMLERINI COK DAHA KOLAY YAPABILIRIZ.
 */

        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım

        //Tekrar amazon sayfasına dönüp iphone aratalım
        //Arama sonucunun resmini alalım
    }
}
