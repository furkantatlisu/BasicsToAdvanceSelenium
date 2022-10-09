import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

    public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://google.com");
        driver.navigate().to("https://rahulshettyacademy.com");
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
    }

}