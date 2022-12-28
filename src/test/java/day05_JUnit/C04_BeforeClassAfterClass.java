package day05_JUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class C04_BeforeClassAfterClass {
    /*
        @BeforeClass ve @AfterClass notasyonları sadece static method'lar için çalışır.
    @BeforeClass ve @AfterClass kullanırsak oluşturduğumuz @Test methodlarının hepsini aynı anda çalıştırıp
    en son @AfterClass'ı çalıştırırız
        Ama sadece @Before ve @After kullanırsak her test için @before ve @after'i kullnır.
     */
    @BeforeClass
    public static void setUp(){
        System.out.println("Bütün Testlerden önce çalıştı");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("Bütün Testlerden sonra çalıştı");
        System.out.println("------------------------------");
    }
    @Before
    public void setUp01(){
        System.out.println("Her test ten once calisir");
        System.out.println("-------------------------");
    }
    @After
    public void teardown(){
        System.out.println("Her testten sonra calisir");
        System.out.println("-------------------------");
    }
    @Test
    public void test01(){
        System.out.println("Ilk Test");
        System.out.println("-------------------------");
    }
    @Test
    public void test02(){
        System.out.println("Ikinci Test");
        System.out.println("-------------------------");
    }
    @Test
    @Ignore  //Eger bir testi calistirmak istemezsek bu sekilde kullanabiliriz
    public void test03(){
        System.out.println("Ucuncu test");
    }
}
