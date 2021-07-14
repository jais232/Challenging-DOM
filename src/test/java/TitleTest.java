

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class TitleTest {

    private WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
    }

    @Test
    public void assertTitle() {
        // check the title of the page is correctly displayed


        //driver.findElement(By.cssSelector(".button.alert")).click();
        String expectedTitle = "The Internet";
        String actualTitle = "";
        actualTitle=driver.getTitle();
        System.out.println("The page title reads: " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("The title is successfully verified");

    }
    @After
    public void close() {
        driver.quit();
    }


}