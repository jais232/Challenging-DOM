

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;


public class EditDeleteTest {

    private WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
    }

    @Test
    public void checkEdit() {
        // check the editing functionality is disabled

        String expectedData = "Phaedrum0";

        driver.findElement(By.linkText("edit")).click();

        String recordData = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[6]")).getText();
        System.out.println(" " + recordData);


        if (recordData.contentEquals(expectedData)){
            System.out.println("Editing is properly disabled");
        } else {
            System.out.println("Test Failed");
        }
    }

    @Test
    public void checkDelete() {
        // check the delete functionality is disabled

        String existingData = "Phaedrum0"; //reading the existing data record

        driver.findElement(By.linkText("delete")).click(); //deleting the same record

        String newData = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[6]")).getText();
        System.out.println(" " + newData);

        // using if condition to determine the data is not lost in deletion
        if (newData.contentEquals(existingData)){
            System.out.println("Delete functionality is properly disabled");
        } else {
            System.out.println("Test Failed");
        }
    }

    @After
    public void close() {
        driver.quit();
    }


}