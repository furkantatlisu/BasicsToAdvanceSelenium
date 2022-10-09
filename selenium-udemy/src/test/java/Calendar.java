import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Calendar {

    public static ChromeDriver driver;

    public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
        ChromeDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("https://www.path2usa.com/travel-companions");

        Actions action = new Actions(driver);
//April 23-
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@name=\"form_fields[travel_comp_date]\"]").click();

        while(!driver.findElement(By.cssSelector("[class='cur-month']")).getText().contains("May"))
        {
            driver.findElement(By.cssSelector("[class='flatpickr-next-month']")).click();
            Thread.sleep(500);
        }

        List<WebElement> dates= driver.findElements(By.className("flatpickr-day"));
//Grab common attribute//Put into list and iterate
        int count=dates.size();

        for(int i=0;i<count;i++)
        {
            String text=dates.get(i).getText();
            if(text.equalsIgnoreCase("21"))
            {
                dates.get(i).click();
                break;
            }
        }
    }
}