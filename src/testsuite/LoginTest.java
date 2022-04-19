package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

String BaseUrl = "https://demo.nopcommerce.com/";

@Before

    public void setUp()
{
    openBrowser(BaseUrl);
}


@Test
// find login link and click on login link
public void userShouldNavigateToLoginPageSuccessfully()
{
    WebElement loginLink = driver.findElement(By.linkText("Log in"));
    loginLink.click();
    // This is from requirement
    String expectMessage = "Welcome, Please Sign In!";
    // find the welcome text element and get the text
    WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
    String actualMessage = actualMessageElement.getText();
    // verify actual and expected text using Assert
    Assert.assertEquals("login page message not matching",actualMessage,expectMessage);
}
@Test
// verifying user should be able to login with valid credentials
public void userShouldLoginSuccessfullyWithValidCredentials(){
    String expectedMessage = "Log out";
    WebElement loginLink = driver.findElement(By.linkText("Log in"));
    loginLink.click();

    WebElement userName = driver.findElement(By.id("Email"));
    userName.sendKeys("xyz@gmail.com");

    WebElement passWord = driver.findElement(By.id("Password"));
    passWord.sendKeys("Temp123");

    WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
    login.click();

    WebElement actualMessageelement = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
    String actualMessage = actualMessageelement.getText();

    Assert.assertEquals("Logout text is not matching",actualMessage,expectedMessage);

}
@Test
// verify the error message with invalid credentials
public void verifyTheErrorMessage(){
    // this is from requirement
    String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
            + "No customer account found";

    WebElement loginLink = driver.findElement(By.linkText("Log in"));
    loginLink.click();

    WebElement userName = driver.findElement(By.id("Email"));
    userName.sendKeys("abc@yahoo.com");

    WebElement passWord = driver.findElement(By.id("Password"));
    passWord.sendKeys("abc123");

    WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
    login.click();

    WebElement actualMessageElement = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"));
    String actualmessage = actualMessageElement.getText();
    //Verify the text error message with assert
    Assert.assertEquals("Error Message not displayed",actualmessage,expectedMessage);

}
    @After
    public void tearDown()
    {
        closeBrowser();
    }

}
