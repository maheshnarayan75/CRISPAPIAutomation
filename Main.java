import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;


public class Main {

    public static void main(String[] args) {
        // Read test data from config.properties
        Properties properties = new Properties();
        try {
            FileInputStream configFile = new FileInputStream("config.properties");
            properties.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to registration page
        driver.get(properties.getProperty("app.url") + "/register");

        // Fill in registration form
        driver.findElement(By.id("name")).sendKeys(properties.getProperty("user.name"));
        driver.findElement(By.id("dob")).sendKeys(properties.getProperty("user.dob"));
        driver.findElement(By.id("address")).sendKeys(properties.getProperty("user.address"));
        driver.findElement(By.id("submit")).click();

        // Validate successful registration (assertions, screenshots, etc.)

        // Close the browser
        driver.quit();
    }
}
