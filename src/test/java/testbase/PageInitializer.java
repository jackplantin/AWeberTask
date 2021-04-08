package testbase;

import com.hrms.pages.*;

public class PageInitializer extends BaseClass {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeInfoPage employeeInfoPage;
    public static ViewEmployeePage viewEmployeePage;
    public static PIMConfigurationPage pimConfigurationPage;

    public static void initializePageObjects() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        addEmployeePage = new AddEmployeePage();
        employeeInfoPage = new EmployeeInfoPage();
        viewEmployeePage = new ViewEmployeePage();
        pimConfigurationPage = new PIMConfigurationPage();
    }
}
