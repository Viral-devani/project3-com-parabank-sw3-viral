package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigingUpPageDisplay() {
        //click on the 'Register Link'
        clickOnElement(By.xpath("//a[normalize-space()='Register']"));
        //Verify the text 'Signing up is easy'
        String expectedMessage = "Signing up is easy!";
        WebElement actualTextMessage = driver.findElement(By.xpath("//h1[normalize-space()='Signing up is easy!']"));
        String actualMessage = actualTextMessage.getText();
        //validate actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //Click on Register Link
        clickOnElement(By.xpath("//a[normalize-space()='Register']"));
        //Enter First Name
        driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Prince");
        //Enter Last name
        sendTextToElement(By.xpath("//input[@id='customer.lastName']"), "Royal");
        //Enter Address
        sendTextToElement(By.xpath("//input[@id='customer.address.street']"), "1 Buckingham ");
        // Enter City
        sendTextToElement(By.xpath("//input[@id='customer.address.city']"), "London");
        // Enter State
        sendTextToElement(By.xpath("//input[@id='customer.address.state']"), "UK");
        //Enter Zip Code
        sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"), "SW1A 1AA");
        //Enter Phone
        sendTextToElement(By.xpath("//input[@id='customer.phoneNumber']"), "0755857700");
        // Enter SSN
        sendTextToElement(By.xpath("//input[@id='customer.ssn']"), "12345");
        //Enter Username
        sendTextToElement(By.xpath("//input[@id='customer.username']"), "Prince2");
        // Enter Password
        sendTextToElement(By.xpath("//input[@id='customer.password']"), "xyz1");
        // Enter Confirm
        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"), "xyz1");
        // Click on REGISTER button
        clickOnElement(By.xpath("//input[@value='Register']"));
        //Verify the text 'Your account was created successfully. You are now logged in.’
        verifyElements("Your account was created successfully. You are now logged in.",By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in')]"),"Not Logged in successfully");

    }
    @After
    public void closeBrowser() {
        driver.quit();
    }


}
