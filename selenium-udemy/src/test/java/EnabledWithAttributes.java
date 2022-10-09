import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EnabledWithAttributes {

        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("http://spicejet.com");

            System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
            driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
            System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
            if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
            {
                System.out.println("its enabled");
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertTrue(false);
            }
        }
}


