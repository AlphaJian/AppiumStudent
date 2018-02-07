package test;

import pages.portal.LoginPage;
import pages.portal.WelcomePage;
import org.testng.annotations.*;

public class PortalTest extends BaseTest {
    @Test
    public void LoginTest() throws Exception {

        System.out.println("?????");
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.loginButtonTapped();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitAWhile();
        System.out.println("Enter login page");

        loginPage.toggleButtonTapped();
        System.out.println("Toggle button tapped");

        loginPage.waitForToggleChanged();
        System.out.println("Title changed");

        loginPage.findTextfields();
        loginPage.enterUsername("13524276478");
        loginPage.enterPassword("222222");

        loginPage.loginTapped();
    }
}
