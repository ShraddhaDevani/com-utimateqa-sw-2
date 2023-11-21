package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://courses.ultimateqa.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldNavigateToLoginPageSuccessfully() {
        //Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //Verify the text “Welcome Back!”
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //Enter the email to email field
        driver.findElement(By.id("user[email]")).sendKeys("Shraddhadev@gmail.com");

        //Enter the password field
        driver.findElement(By.id("user[password]")).sendKeys("shriji123");

        //Click on login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify the error message ‘Invalid email or password.’
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//form[@id='sign_in_1869c87830']/div/ul/li")).getText();
        Assert.assertEquals(actualText, expectedText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}