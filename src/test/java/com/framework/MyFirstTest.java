package com.framework;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;


public class MyFirstTest {

    public static final String BASE_URL = "https://github.com/";
    static WebDriver driver;

    @BeforeAll
    static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seela\\IdeaProjects\\MyTestFramework\\lib\\windows\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
   static void cleanUp() {
        driver.close();
    }

    @Test
    public void myFristTest() {

            String user = "andrejs-ps";
            driver.get(BASE_URL + user);

            //Act
            String actualuserName = driver.findElement(By.xpath("//span[@itemprop=\"additionalName\"]")).getText();

            //Assert
            assertEquals(user, actualuserName);

    }

    @Test
    public void mySecTest() {

        //Arrange
            String user = "andrejs-ps";
            driver.get(BASE_URL + user);

            //Act
            String repo = "automated-tests-in-java-with-fluent-interface-using-webdriver-selenium";
            WebElement repoLink = driver.findElement(By.linkText(repo));
            repoLink.click();
            String currentURL = driver.getCurrentUrl();
            //Assert
            assertEquals(BASE_URL + user +"/"+ repo, currentURL);


    }
}
