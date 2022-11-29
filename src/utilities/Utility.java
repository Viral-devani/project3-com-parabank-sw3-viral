package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {

        WebElement loginLink = driver.findElement(by);
        loginLink.click();

    }



    //this method will send text to element
    public void sendTextToElement(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    /*
    This method will get text from element
    with parameter and return type
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }


    public void verifyElements(String expectedMessage, By by, String displayMessage) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

}
