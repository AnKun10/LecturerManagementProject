package logic;

import entity.Admin;
import entity.Lecturer;
import main.Main;
import utils.Validator;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterFunction {

    public void registerFunction(Scanner scanner, ArrayList<Lecturer> lecturers) {
        System.out.println("Enter User Information for Register");
        // Decentralization: you register as an Admin or a Lecturer
        System.out.print("Enter your role: ");
        System.out.println("1 - Admin");
        System.out.println("2 - Lecturer");
        int decentralization;
        do {
            decentralization = Main.validator.getInt(scanner);
            if ((decentralization == 1 || decentralization == 2)) {
                break;
            }
            System.out.println("You must enter one or two function.");
        } while(true);
        // handle logic for method decentralization between Admin and Lecturer
        registerFunctionLogic(decentralization, scanner, lecturers); // switch case
    }

    private void registerFunctionLogic(int decentralization, Scanner scanner, ArrayList<Lecturer> lecturers) {
        switch (decentralization) {
            case 1:
                registerFunctionAsAdmin(scanner);
                break;
            case 2:
                registerFunctionAsLecturer(scanner, lecturers);
                break;
        }
    }

    // Register information for Lecturer
    private void registerFunctionAsLecturer(Scanner scanner, ArrayList<Lecturer> lecturers) {
        Lecturer lecturer = new Lecturer();
        System.out.println("Enter Information for Lecturer");

        boolean isValid;
        do {
            System.out.print("Username: ");
            lecturer.setUsername(scanner.nextLine().trim());
            isValid = Main.validator.userNameIsValidForLecturer(lecturer.getUsername(), lecturers);
        } while (!isValid);

        do {
            System.out.print("Email: ");
            lecturer.setEmail(scanner.nextLine().trim());
            isValid = Main.validator.emailIsValidForLecturer(lecturer.getEmail(), lecturers);
        } while (!isValid);

        do {
            System.out.print("Phone Number: ");
            lecturer.setPhoneNumb(scanner.nextLine().trim());
            isValid = Main.validator.phoneNumbIsValidForLecturer(lecturer.getPhoneNumb(), lecturers);
        } while (!isValid);

        do {
            System.out.print("Password: ");
            lecturer.setPassword(scanner.nextLine().trim());
            isValid = Main.validator.passIsValid(lecturer.getPassword());
        } while (!isValid);
    }

    // Register information for Admin
    private void registerFunctionAsAdmin(Scanner scanner) {
        Admin admin = new Admin();
        System.out.println("Enter Information for Admin");

        boolean isValid;
        do {
            System.out.print("Username: ");
            admin.setUsername(scanner.nextLine().trim());
            isValid = Main.validator.userNameIsValidForAdmin(admin.getUsername());
        } while (!isValid);

        do {
            System.out.print("Email: ");
            admin.setEmail(scanner.nextLine().trim());
            isValid = Main.validator.emailIsValidForAdmin(admin.getEmail());
        } while (!isValid);

        do {
            System.out.print("Phone Number: ");
            admin.setPhoneNumb(scanner.nextLine().trim());
            isValid = Main.validator.phoneNumbIsValidForAdmin(admin.getPhoneNumb());
        } while (!isValid);

        do {
            System.out.print("Password: ");
            admin.setPassword(scanner.nextLine().trim());
            isValid = Main.validator.passIsValid(admin.getPassword());
        } while (!isValid);
    }


}
