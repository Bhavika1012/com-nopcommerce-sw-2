package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//inheriting from BaseTest class
public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //verifying expected message
        String expectedMessage = "Welcome, Please Sign In!";
        //verifying actual message
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains (text(), 'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Not redirected to login page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find and click on login link
        driver.findElement(By.linkText("Log in")).click();
        //Find email field element and enter valid email
        driver.findElement(By.id("Email")).sendKeys("prime123@gmail.com");
        //Find password field element and enter valid password
        driver.findElement(By.id("Password")).sendKeys("prime123");
        //Find and click on login button
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        String expectedMessage = "Log out";
        WebElement actualMessage = driver.findElement(By.linkText("Log out"));
        //need to find xpath of logout
        String actualTextElement = actualMessage.getText();
        Assert.assertEquals("Unsuccessful login", actualTextElement, expectedMessage);

    }

    @Test
    public void verifyTheErrorMessage() {
        //Find and click on the login link
        driver.findElement(By.linkText("Log in")).click();
        //Find email field element and enter invalid email
        driver.findElement(By.id("Email")).sendKeys("error@gmail.com");
        //Find email field element and enter invalid password
        driver.findElement(By.id("Password")).sendKeys("error123");
        //Click on login button
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        //Expected message for invalid user id and password
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found";
        //Finding log in button using xpath
        WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(@class,'message-error validation-summary-errors')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
