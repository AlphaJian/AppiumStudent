package pages.portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class WelcomePage extends BasePage {
    protected By loginButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
        initialElement();
    }

    private void initialElement() {
        if (configUtil.isIOSPlatform()) {
            loginButton = By.id("登录注册");
        } else {
            loginButton = By.id("com.alo7.android.student:id/go_login_register");
        }
    }

    public void loginButtonTapped() throws Exception {
        waitElementAndClick(loginButton);
    }
}
