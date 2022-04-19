package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String BaseUrl = "https://demo.nopcommerce.com/";
    @Before

    public void setUp()
    {
        openBrowser(BaseUrl);
    }
    @Test
    // find the register elements when clicking on register link
    public void userShouldNavigateToRegisterPageSuccessfully() {
     // This is from requirement document
     String expectedMessage = "Register";
     WebElement registerLink = driver.findElement(By.linkText("Register"));
     registerLink.click();
     WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
     String actualMessage = actualMessageElement.getText();
        //Verify the text ‘Register’ by using Assert
     Assert.assertEquals("Register tab not matching",expectedMessage,actualMessage);
    }
    @Test
    // Verifying user should be able to complete the registration by providing all details
    public void userShouldRegisterAccountSuccessfully() {
        // This is from requirement
        String expectedMessage = "Your registration completed";
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        WebElement radiobutton = driver.findElement(By.id("gender-male"));
        radiobutton.click();
        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("test123");
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("test456");
        WebElement dayOfBirthday = driver.findElement(By.name("DateOfBirthDay"));
        dayOfBirthday.sendKeys("17");
        WebElement dateOfBirthMonth = driver.findElement(By.name("DateOfBirthMonth"));
        dateOfBirthMonth.sendKeys("April");
        WebElement dateOfBirthYear = driver.findElement(By.name("DateOfBirthYear"));
        dateOfBirthYear.sendKeys("1985");
        WebElement emailID = driver.findElement(By.id("Email"));
        emailID.sendKeys("xyz123456789@gmail.com");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Temp123");
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("Temp123");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualMessage = actualMessageElement.getText();
        //Verify the text ‘Your registration completed’ by using Assert
        Assert.assertEquals("Registration not completed",expectedMessage,actualMessage);
    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }

}
