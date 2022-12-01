package logic;

import entity.Admin;
import entity.Lecturer;
import main.Main;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginFunction {

    public void login(Scanner scanner, ArrayList<Admin> admins, ArrayList<Lecturer> lecturers) {
        System.out.println("----LOGIN-----");
        System.out.println("Enter your Role you log in with: ");
        System.out.println("1 - Admin");
        System.out.println("2 - Lecturer");
        int choice;
        do {
            choice = Main.validator.getInt(scanner);
            if (( choice == 1 ) || (choice == 2)) {
                break;
            }
            System.out.println("You must choose number one or two!");
        } while (true);
        loginDecentralization(scanner, choice, admins, lecturers);
    }

    private void loginDecentralization(Scanner scanner, int choice, ArrayList<Admin> admins, ArrayList<Lecturer> lecturers) {
        AdminFunction adminFunction = new AdminFunction();
        LecturerFunction lecturerFunction = new LecturerFunction();
        switch (choice) {
            case 1:
                adminFunction.loginAsAdmin(scanner, admins);
                break;
            case 2:
                lecturerFunction.loginAsLecturer(scanner, lecturers);
                break;
        }
    }

}
