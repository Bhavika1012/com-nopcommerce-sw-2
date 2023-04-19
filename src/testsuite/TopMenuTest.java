package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends LoginTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setBaseUrl() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //finding and clicking on "Computers" tab on topmenu
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']")).click();
        //verifying expected and actual text using xpath
        String expectedMessage = "Computers";
        WebElement actualElementMessage = driver.findElement(By.xpath("//h1[text()='Computers']"));
        String actualMessage = actualElementMessage.getText();
        Assert.assertEquals("User is not navigated to Computer page", actualMessage, expectedMessage);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        //finding and clicking on 'Electronics' tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']")).click();
        //verifying expected text using xpath
        String expectedMessage = "Electronics";
        WebElement actualElementMessage = driver.findElement(By.xpath("//h1[text()='Electronics']"));
        String actualMessage = actualElementMessage.getText();
        Assert.assertEquals("User is not navigated to the Electronics page", actualMessage, expectedMessage);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessful() {
        //finding and clicking on the 'Apparel' tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/apparel']")).click();
        String expectedMessage = "Apparel";
        //verifying expected text using xpath
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[text()='Apparel']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("User is not navigated to the Apparel page", expectedMessage, actualMessage);
    }

    @Test

    public void userShouldNavigateToDigitalDownloadsPageSuccessful() {
        //finding and clicking on the 'Digital Downloads' tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/digital-downloads']")).click();
        String expectedMessage = "Digital downloads";
        //verifying expected text using xpath
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[text()='Digital downloads']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("User is not navigated to the Digital downloads page", expectedMessage, actualMessage);
    }

    @Test

    public void userShouldNavigateToBooksPageSuccessfully() {
        String expectedMessage = "Books";
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/books']")).click();
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[text()='Books']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("User is not navigated to the Books page", expectedMessage, actualMessage);
    }

    @Test

    public void userShouldNavigateToJewelryPageSuccessfully() {
        String expectedMessage = "Jewelry";
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/jewelry']")).click();
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[text()='Jewelry']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("User is not navigated to the Jewelry page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessful() {
        String expectedMessage = "Gift Cards";
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/gift-cards']")).click();
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[text()='Gift Cards']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("User is not navigated to the Gift Cards page", expectedMessage, actualMessage);
    }

}
