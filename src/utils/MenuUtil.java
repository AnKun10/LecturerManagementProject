package utils;

public class MenuUtil {

    public void displayLoginMenu() {
        System.out.println("1 - Login");
        System.out.println("2 - Register");
        System.out.println("0 - Exit Program");
    }

    public void displayLoginMenuFailed() {
        System.out.println("1 - Login Again");
        System.out.println("2 - Forget Password");
        System.out.println("0 - Exit Program");
    }

    public void displayAdminMainMenu() {
        System.out.println("-----WELCOME TO LECTURER MANAGEMENT PROGRAM-----");
        System.out.println("1 - Settings and privacy");
        System.out.println("2 - Lecturer Management");
        System.out.println("0 - Logout"); // return to Login Menu
    }

    // After changing Username/ Email/ Password/ PhoneNumber, back to Setting And Privacy Menu
    public void displaySettingsAndPrivacyMenu() {
        System.out.println("1 - Change Username");
        System.out.println("2 - Change Email");
        System.out.println("3 - Change Password");
        System.out.println("4 - Change Phone Number");
        System.out.println("0 - Back to Main Menu");
    }

    public void displayLecturerManagementMenu() {
        System.out.println("1 - Update");
        System.out.println("2 - Display Schedule");
        System.out.println("0 - Back to Main Menu");
    }

    public void displayUpdateMenu() {
        System.out.println("1 - Lecturer");
        System.out.println("2 - Clazz");
        System.out.println("0 - Back to Lecturer Management Menu");
    }

    public void displayUpdateMenuDetail() { //
        System.out.println("1 - Add");
        System.out.println("2 - Remove");
        System.out.println("3 - Change");
        System.out.println("4 - Back to Update Menu");
    }
    //After sorting, back to Display Schedule Menu
    public void displayScheduleMenu() {
        System.out.println("1 - Sort by Lecturer");
        System.out.println("2 - Sort by Location");
        System.out.println("0 - Back to Lecturer Management Menu");
    }

    
}
