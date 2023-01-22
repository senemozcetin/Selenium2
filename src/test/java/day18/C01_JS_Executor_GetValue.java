package day18;

import org.junit.Test;
import utilities.TestBase;

public class C01_JS_Executor_GetValue extends TestBase {
    @Test
    public void test01() {
        //getValueTest methodu olustur
        //https://www.priceline.com/ git
        //Tarih kismindaki yazili metinleri al ve yazdir
        driver.get("https://www.priceline.com/");
        getValueByJS("hotelDates");

    }
}
