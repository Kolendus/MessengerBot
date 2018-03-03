
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;


public class MessengerBot {


    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        
		//Chrome driver needed , download it and paste path to .exe file down here
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michał\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
		//assertion, if messengerbot is ran on slower computer, you can increase pause interval
        WebDriverWait wait = new WebDriverWait(driver, 3);

		
		
        driver.get("http://www.facebook.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        
		driver.findElement(By.name("email")).sendKeys("your_email");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")));
        driver.findElement(By.name("pass")).sendKeys("your_password");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbutton")));
        driver.findElement(By.id("loginbutton")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mercurymessages")));
        driver.findElement(By.name("mercurymessages")).click();

		//Here is the tricky part. Right click mouse on chatbox with a friend whom you want to send spam to, and then proceed to analyze the HTML code.
		//You have to find a link href=www.facebook (...). Then paste it down there
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='https://www.facebook.com/messages/t/1576951690")));
        driver.findElement(By.cssSelector("a[href*='https://www.facebook.com/messages/t/1576951690")).click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_5rpu")));
        WebElement mssgbox =  driver.findElement(By.className("_5rpu"));


       for(int i = 0; i < 10; i++) {
            mssgbox.sendKeys("Message-input" + Keys.ENTER);
        }

        driver.quit();

    }
}
