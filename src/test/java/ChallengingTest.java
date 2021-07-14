

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ChallengingTest {

    private WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver",  "src/test/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
    }

    @Test
    public void greenRed() {
    // when both green and red buttons are clicked
        driver.findElement(By.cssSelector(".button.success")).click(); //using css selector of tag+class
        driver.findElement(By.cssSelector(".button.alert")).click();


        String blueMsg = driver.findElement(By.cssSelector(".button")).getText(); //add here
        System.out.println("The Blue button reads: " + blueMsg);

    }

    @Test
    public void greenBlue() {
    // when both green and blue buttons are clicked
        driver.findElement(By.cssSelector(".button.success")).click();
        driver.findElement(By.cssSelector(".button")).click();


        String redMsg = driver.findElement(By.cssSelector(".button.alert")).getText();
        System.out.println("The Red button reads: " + redMsg);
        }

    @Test
    public void blueRed() {
    // when both blue and red buttons are clicked
        driver.findElement(By.cssSelector(".button")).click();
        driver.findElement(By.cssSelector(".button.alert")).click();


        String greenMsg = driver.findElement(By.cssSelector(".button.success")).getText();
        System.out.println("The Green button reads: " + greenMsg);
    }

    @Test
    public void onlyGreen() {
    // when only green button is clicked
        driver.findElement(By.cssSelector(".button.success")).click();

        String redMsg = driver.findElement(By.cssSelector(".button.alert")).getText();
        System.out.println("The Red button reads: " + redMsg);

        String blueMsg = driver.findElement(By.cssSelector(".button")).getText();
        System.out.println("The Blue button reads: " + blueMsg);

        /*String greenMsg = driver.findElement(By.cssSelector(".button.success")).getText();
        System.out.println("The Green button reads: " + greenMsg);*/
    }

    @Test
    public void onlyBlue() {
        // when only blue button is clicked
        driver.findElement(By.cssSelector(".button")).click();

        String redMsg = driver.findElement(By.cssSelector(".button.alert")).getText();
        System.out.println("The Red button reads: " + redMsg);

        /*String blueMsg = driver.findElement(By.cssSelector(".button")).getText();
        System.out.println("The Blue button reads: " + blueMsg);*/

        String greenMsg = driver.findElement(By.cssSelector(".button.success")).getText();
        System.out.println("The Green button reads: " + greenMsg);
    }

    @Test
    public void onlyRed() {
        // when only red button is clicked
        driver.findElement(By.cssSelector(".button.success")).click();

        /*String redMsg = driver.findElement(By.cssSelector(".button.alert")).getText();
        System.out.println("The Red button reads: " + redMsg);*/

        String blueMsg = driver.findElement(By.cssSelector(".button")).getText();
        System.out.println("The Blue button reads: " + blueMsg);

        String greenMsg = driver.findElement(By.cssSelector(".button.success")).getText();
        System.out.println("The Green button reads: " + greenMsg);
    }

    @Test
    public void allButtons() {
        // when all buttons are clicked
        driver.findElement(By.cssSelector(".button")).click();
        driver.findElement(By.cssSelector(".button.alert")).click();
        driver.findElement(By.cssSelector(".button.success")).click();


        String redMsg = driver.findElement(By.cssSelector(".button.alert")).getText();
        System.out.println("The Red button reads: " + redMsg);

        String blueMsg = driver.findElement(By.cssSelector(".button")).getText();
        System.out.println("The Blue button reads: " + blueMsg);

        String greenMsg = driver.findElement(By.cssSelector(".button.success")).getText();
        System.out.println("The Green button reads: " + greenMsg);
    }

    @After
    public void close() {
        driver.quit();
    }
}
