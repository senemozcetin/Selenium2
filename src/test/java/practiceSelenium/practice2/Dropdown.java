package practiceSelenium.practice2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Dropdown extends TestBase {
    @Test
    public void test01(){
        //amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Dropdown menuyu yazdiralim
        List<WebElement> dropdown= driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        //Select select= new Select(dropdown

        //dropdown menuden baby secelim
        dropdown.forEach(t-> System.out.println(t.getText()));

        //arama bolumunden milk aratalim
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby"
                , Keys.TAB,"Milk",Keys.ENTER);
    }
}
