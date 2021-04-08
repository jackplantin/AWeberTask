package testbase;

import pages.ProfilePage;

public class PageInitializer extends BaseClass {

    public static ProfilePage profilePage;

    public static void initializePageObjects() {
        profilePage = new ProfilePage();
    }
}
