
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class NavigateCommand {

        public static void main(String[] args) throws InterruptedException {

            File file = new File("src/main/resources/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            WebDriver driver = new ChromeDriver();// ChomeDriver is an implementation of a web driver interface

            WebDriverWait wait=new WebDriverWait(driver, 5);

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;




            // Launch Website

            driver.manage().window().maximize();
            driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");

            //Click on the Link Text using click() command

            //WebElement linkText = driver.findElement(By.linkText("Link"));
            //WebElement linkText = driver.findElement(new By.ByXPath("/html/body/div/div[4]/div/p/a"));
            WebElement linkText = driver.findElement(new By.ByLinkText("This is a link"));

            // It checks if the linkText is Enable or not.
            if(linkText.isEnabled()){
                System.out.println("The linkText is enable");
            }
            // It checks if the linkText is Displayed or not.
            if(linkText.isDisplayed()){
                System.out.println("The linktext is Displayed");
            }

            wait.until(ExpectedConditions.elementToBeClickable(linkText));

            System.out.println(linkText.getText());

            linkText.click();

            ///html/body/div/div[4]/div/p/a   linkText xpath Adrress

            //Go back to Home Page
            driver.navigate().back();
            Thread.sleep(3000);   // This kind of wait is not recommended I put here just for observing
            wait.until(ExpectedConditions.titleIs("Sample Test Page"));
            System.out.println(driver.getTitle());
            //System.out.println(linkText.getText());  It is not working because Stale Element Reference Error


            //Go forward to Registration page
            driver.navigate().forward();

            // Go back to Home page
            driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");

            //Refresh browser
            driver.navigate().refresh();

            //Closing browser
            driver.close();
        }
    }

