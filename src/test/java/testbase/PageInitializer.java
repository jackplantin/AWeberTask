package testbase;

import pages.DashboardPage;
import pages.LoginPage;
import pages.ProfilePage;

public class PageInitializer extends BaseClass {

    public static ProfilePage profilePage;
    public static DashboardPage dashboardPage;
    public static LoginPage loginPage;

    public static void initializePageObjects() {
        profilePage = new ProfilePage();
        dashboardPage = new DashboardPage();
        loginPage = new LoginPage();
    }
}
