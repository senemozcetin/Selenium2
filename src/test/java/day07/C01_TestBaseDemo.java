package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    /*
    UTILITIES:
    -Utilities tekrar tekrar kullanacagimiz methodlari ya da class lari koydugumuz
    package in adidir.(depo)
        -TestBase
        -Driver
        -ExcelUtil
        -Configuration
   -Utilities package inda Test case ler yazilmaz.Sadece tekrar kullanilabilecek destek siniflari
   (support class) olusturulur. Bu support class lar test case lerin yazilmasini hizlandirir.

     */
    @Test
    public void test01(){
        //techproeducation ana sayfasina git ve
        // title in Bootcamps kelimesini icerdigini test edelim
        driver.get("https://techproeducation.com");
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Bootcamps"));
    }



}
