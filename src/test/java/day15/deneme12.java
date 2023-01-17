package day15;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class deneme12 extends TestBase {
    protected static ExtentTest test;
    protected static ExtentReports  reports;
    protected static ExtentHtmlReporter  htmlReporter;
    @Test
    public void test01() {

        String suan= new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/senem/raporlar-deneme/"+suan+ "deneme.html";

         htmlReporter= new ExtentHtmlReporter(path);
         reports= new ExtentReports();



        reports.setSystemInfo("QA","Senem");
        reports.setSystemInfo("Salesforce Dev","Serdal");
        reports.setSystemInfo("Sprint","3.sprint");
        reports.setSystemInfo("environment","regression");

        htmlReporter.config().setDocumentTitle("Html Title");
        htmlReporter.config().setReportName("Rapor ismi");

        reports.attachReporter(htmlReporter);
        test = reports.createTest("Testin ismi yazilir", "aciklama, tanimlama yazilir");
        test.info("Test bilgisi verilir");
        test.skip("atla gec anlaminda kullanilir");
        test.pass("passed oldugunu gosterir");
        test.fail("falied oldugu durumlarda kullanilir");
        test.fatal("buyuk bir hata varsa kullanilir");
        test.warning("uyari vermek icin kullanilir");
        test.debug("debug nedir");

        reports.flush();






    }
}