import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SeperateTabs {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
//1. Give me the count of links on the page.
        //2. Count of footer section-
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerdriver=driver.findElement(By.id("gf-BIG")); //limiting webdriver scope
        System.out.println(driver.findElements(By.tagName("a")).size());
        //3-
        WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int size=columndriver.findElements(By.tagName("a")).size();

        System.out.println(size);
        //4- click on each link in the coloumn and check if the pages are opening-
        for (int i=0;i<size;i++){
            String clickOnLinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER); //ctrl+ left click for new tab
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);     //opens all the tabs
            Thread.sleep(3000);
        }
        Set<String> abc=driver.getWindowHandles();
        Iterator<String> it= abc.iterator();
        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
			