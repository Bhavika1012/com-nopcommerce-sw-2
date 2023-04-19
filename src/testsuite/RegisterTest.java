package testsuite;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends TopMenuTest {
    @Test
    public void UserShouldNavigateToRegisterPageSuccessfully() {
        //Finding and clicking on 'Register' link
        driver.findElement(By.xpath("//a[@href='/register?returnUrl=%2F']")).click();
        //Stating expected message
        String expectedMessage = "Register";
        //Finding actual message
        WebElement actualMessage = driver.findElement(By.xpath("//h1[text()='Register']"));
        String actualMessageText = actualMessage.getText();
        Assert.assertEquals("User is not navigated to registration page", expectedMessage, actualMessageText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //Find and click on the 'Register' link
        driver.findElement(By.xpath("//a[@href='/register?returnUrl=%2F']")).click();
        //Select gender radio button
        driver.findElement(By.id("gender-female")).click();
        //Enter first name
        driver.findElement(By.id("FirstName")).sendKeys("Sophia");
        //Enter last name
        driver.findElement(By.id("LastName")).sendKeys("Smith");
        //enter email id
        driver.findElement(By.id("Email")).sendKeys("sophiasmith@gmail.com"); //Registration will show as user already exists
        //Select from dropdown list for date of birth
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("12");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("January");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1994");
        //Enter password
        driver.findElement(By.id("Password")).sendKeys("1234567");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("1234567");
        //Click the register button
        driver.findElement(By.id("register-button")).click();
        //Find registration completion page
        String expectedMessage = "Your registration completed";
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


}

