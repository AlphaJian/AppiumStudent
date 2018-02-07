package pages.portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class LoginPage extends BasePage {
    protected By togglePasswordButton;
    protected By loginButton;

    protected WebElement usernameTextField;
    protected WebElement passwordTextField;


    public LoginPage(WebDriver driver) {
        super(driver);
        initialElement();
    }

    private void initialElement() {
        if (configUtil.isIOSPlatform()) {
            togglePasswordButton = By.id("账号密码登录");
            loginButton = By.id("登录");

            titleLabel = By.xpath("//XCUIElementTypeStaticText[@name='手机号验证登录']");

        } else {
            togglePasswordButton = By.id("com.alo7.android.student:id/other_login");
            loginButton = By.id("com.alo7.android.student:id/login");

            titleLabel = By.xpath("//android.widget.TextView[@text='手机号验证登录']");
        }
    }

    public void toggleButtonTapped() throws Exception {
        waitElementAndClick(togglePasswordButton);
    }

    public void loginTapped() throws Exception {
        driver.findElement(loginButton).click();
    }

    public void findTextfields() {
        if (configUtil.isIOSPlatform()) {
            List<WebElement> eles = driver.findElements(By.className("XCUIElementTypeTextField"));
            if (eles.size() > 0) {
                usernameTextField = eles.get(0);
            }

            List<WebElement> pwds = driver.findElements(By.className("XCUIElementTypeSecureTextField"));
            if (pwds.size() > 0) {
                passwordTextField = pwds.get(0);
            }
        } else {
            List<WebElement> eles = driver.findElements(By.className("android.widget.EditText"));
            if (eles.size() > 1) {
                usernameTextField = eles.get(0);
                passwordTextField = eles.get(1);
            }
        }
    }

    public void findTextViewAndEnter(WebElement el, String value){
        waitAWhile();
        el.click();
        el.clear();
        el.sendKeys(value);
        if(configUtil.isIOSPlatform()) {
            el.sendKeys("\n");

        } else {
        }
    }

    public void waitForToggleChanged() throws Exception {
        if (configUtil.isIOSPlatform()) {
            titleLabel = By.xpath("//XCUIElementTypeStaticText[@name='账号密码登录']");
        } else {
            titleLabel = By.xpath("//android.widget.TextView[@text='账号密码登录']");
        }
        waitForTitle();
    }

    public void enterUsername(String name) {
        findTextViewAndEnter(usernameTextField, name);
    }

    public void enterPassword(String pwd) {
        findTextViewAndEnter(passwordTextField, pwd);
    }
}
