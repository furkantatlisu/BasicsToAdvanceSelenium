import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class _14_Filter {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        WebElement searchBoxElement = driver.findElement(By.id("search-field"));
        searchBoxElement.sendKeys("Rice");
        List<WebElement> listFoundElement = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredList = listFoundElement.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(listFoundElement.size(),filteredList.size(),"is not equal");


    }
}
