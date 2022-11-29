package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
@Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid username
        sendTextToElement(By.xpath("//input[@name='username']"), "Prince2");
        //Enter valid password
        sendTextToElement(By.xpath("//input[@name='password']"), "xyz1");
        //Click on 'Login Button'
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //Verify the 'Accounts Overview' text is display
    verifyElements("Accounts Overview",By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1"),"Login not successfully");


    }


    @Test

    public void verifyTheErrorMessage() {
        //Enter invalid username
        sendTextToElement(By.xpath("//input[@name='username']"), "viral1");
        //enter invalid password
        sendTextToElement(By.xpath("//input[@name='password']"), "abcdef");
        //Click on LoginButton
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //Verify the error message ‘The username and password could not be verified.’
        verifyElements("The username and password could not be verified.",By.xpath("/html/body/div[1]/div[3]/div[2]/p"),"invalid login");


    }


    @Test

    public void userShouldLogOutSuccessfully() {
        //Enter valid username
        sendTextToElement(By.xpath("//input[@name='username']"), "Prince2");
        //Enter valid password
        sendTextToElement(By.xpath("//input[@name='password']"), "xyz1");
        //click on 'Login'button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //click on 'Log out' link
        clickOnElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[8]/a"));
        //Verify the text'Customer Login'
        verifyElements("Customer Login",By.xpath("/html/body/div[1]/div[3]/div[1]/h2"),"Not logged out successfully");


    }
    @After
    public void closeBrowser() {
        driver.quit();
    }

}
