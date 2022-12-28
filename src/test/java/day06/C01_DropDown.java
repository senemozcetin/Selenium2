package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
    /*
    Otomasyon adimlari nelerdir?
1) Test kabul kriterleri dikkatlice okunur
2) Test case olusturulur
3) İlk once manuel test edilir
4) Her sey yolundaysa, otomasyon senaryolarinin testi yapilir
5) Hata ya da eksiklik varsa developerla konusulur, developer (gelistirici) sorunu duzelttiginde tekrar test edilir
6) Otomasyon testi tamamlandiginda konuyla ilgili rapor hazirlanir
i) Html raporu olusturulur
ii) Raporlar Jıra ya yuklenir
iii)Rapor hazırlarken, manuel testler icin ek
Test PASS durumunda;
Rapor hazırlanip JIRA'ya yuklenir

Test FAIL durumunda;
Basarisiz olmasinin nedeni ya veri ya da bug(hata) olabilir
Hatadan emin olmak icin yeniden test edilir
Eger bug kaynakli ise developerlarla konusulur ve  hatalari duzeltmeleri icin sure verilir
Hata duzeltildiginde tekrar test edilir ve rapor JIRA ya yuklenir

iii)Rapor hazırlarken, manuel testler icin ekran goruntusunu de JIRA'ya eklemek gerekir
     */
    WebDriver driver;
    //Eger test sinifinda birden fazla method olusturulmussa @Before kullanilir
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void selectByIndexText() {

        //Dogum yilini , ayini, gununu su sekilde secer: 2000/ January, 10
        //1.LOCATE dropdown element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        //2.SELECT objesi olustur
        Select yearDropdown = new Select(year);
        //3.Select objesini kullanarak 3 farkli sekilde secim yapabilirim
        yearDropdown.selectByIndex(22); //Secenek sirasi 0'dan baslar

        //Ay secimi:
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select monthDropDown = new Select(month);
        monthDropDown.selectByValue("0"); //option  in value degeri ile secim yapilabilir. January seceneginin value si 0

        //Gun secimi
        WebElement day = driver.findElement(By.id("day"));
        Select dayDropDown = new Select(day);
        dayDropDown.selectByVisibleText("10"); // CASE SENSITIVE
    }
        @Test
        public void printAllTest(){
            //Tum eyalet isimlerini konsola yazdir
            WebElement state= driver.findElement(By.xpath("//select[@id='state']"));
            Select stateDropdown= new Select(state);
            List<WebElement> stateList = stateDropdown.getOptions(); //getOption() methodu ile tum state elemanlarini list e koyduk
            stateList.stream().forEach(t-> System.out.println(t.getText()));// lambda ile print ettik. foreach ile de yapilabilir
        }

        @Test
    public void getSelectedOptionsTest(){
            //State dropdown indaki varsayilan secili secenegin 'Select a State' oldugunu verify(dogrulama) edelim
            WebElement state= driver.findElement(By.xpath("//select[@id='state']"));
            Select stateDropdown= new Select(state);
           String varsayilanText=  stateDropdown.getFirstSelectedOption().getText(); //getFirstSelectedOption() secili olan elementi return eder
            Assert.assertEquals("Select a State",varsayilanText);

        }
        @After
    public void tearDown(){

        driver.close();
        }

        /*
        1.What is dropdown? Dropdown nedir?
        Dropdown liste olusturmak icin kullanilir.

        2. How to handle dropdown elements? Dropdown nasil automate edilir?
        - dropdown i locate ederim
        -select objesi olustururum
        -select objesi ile istedigim secenegi secerim
        NOT: Select objesi olusturma nedenim, dropdownlarin Select classi ile olusturulmasi

        3. Tum dropdown seceneklerini nasil print ederiz?
        -tum dropdown elementlerini getOptions() methodu ile listeye koyariz
        -sonra secenekleri loop ile yazdirabiliriz

        4. Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
         Ornek:Gun olarak  10'u sectik ama ya secilmediyse?
         getFirstSelectedOption() secili olan secenegi return eder
         */






}
