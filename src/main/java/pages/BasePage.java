package pages;

import utils.ConfigUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class BasePage {
    protected By titleLabel;

    public ConfigUtility configUtil = ConfigUtility.getInstance();
    protected static WebDriver driver;
    private static final int DEFAULT_WAIT_TIMEOUT = 3;
    private static final int DEFAULT_WAIT_TIME = 2000;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForClickabilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementAndClick(By element) throws Exception {
        try{
            waitForClickabilityOf(element);
            WebElement webElement = driver.findElement(element);
            webElement.click();
        }
        catch (Exception e)
        {
            System.out.println("Element can't be found, or unclickable, throw exception!");
            throw e;
        }
    }

    public void waitForTitle() throws InterruptedException, IOException {
        waitForVisibilityOf(titleLabel);
    }

    public void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitAWhile() {
        wait(DEFAULT_WAIT_TIME);
    }
}
