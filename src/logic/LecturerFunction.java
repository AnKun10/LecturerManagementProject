package logic;

import entity.Lecturer;
import main.Main;
import java.util.ArrayList;
import java.util.Scanner;

public class LecturerFunction {

    private Lecturer currentLecturer;

    // Register
    public void register(Scanner scanner, ArrayList<Lecturer> lecturers) {
        Lecturer lecturer = new Lecturer();
        System.out.println("Enter Lecturer Information for Register");

        System.out.print("Name: ");
        lecturer.setName(scanner.nextLine());

        int age;
        do {
            System.out.println("Age: ");
            age = Main.validator.getInt(scanner);
            if (age > 0) {
                break;
            }
            System.out.println("Age must be a positive number");
        } while (true);

        boolean isValid;
        do {
            System.out.print("Username: ");
            lecturer.setUsername(scanner.nextLine().trim());
            isValid = Main.validator.userNameIsValid(lecturer.getUsername(), lecturers);
        } while (!isValid);

        do {
            System.out.print("Email: ");
            lecturer.setEmail(scanner.nextLine().trim());
            isValid = Main.validator.emailIsValid(lecturer.getEmail(), lecturers);
        } while (!isValid);

        do {
            System.out.print("Phone Number: ");
            lecturer.setPhoneNumb(scanner.nextLine().trim());
            isValid = Main.validator.phoneNumbIsValid(lecturer.getPhoneNumb(), lecturers);
        } while (!isValid);

        do {
            System.out.print("Password: ");
            lecturer.setPassword(scanner.nextLine().trim());
            isValid = Main.validator.passIsValid(lecturer.getPassword());
        } while (!isValid);

        lecturers.add(lecturer); // Add Lecture to the list
        System.out.println("Register Successfully!");
    }

    // Login
    public boolean login4Lecturer(Scanner scanner, ArrayList<Lecturer> lecturers) {
        String username;
        String password;

        System.out.println("Enter Lecturer Information for Login");
        int d = 0;
        // valid username already exits in the list or not
        do {
            System.out.print("Enter Lecturer Username: ");
            username = scanner.nextLine().trim();
            for (Lecturer lecturer : lecturers) {
                if (lecturer.getUsername().equals(username)) {
                    d = 1;
                    break;
                }
            }
            if (d == 0) {
                System.out.println("Lecturer Username is not available, try again!");
            }
        } while (d == 0);
        // valid whether password matches username you have just entered or not
        System.out.print("Enter Lecturer Password: ");
        password = scanner.nextLine().trim();
        d = 0;
        for (int i = 0; i < lecturers.size(); i++) {
            currentLecturer = lecturers.get(i);
            if (currentLecturer.getUsername().equals(username) && currentLecturer.getPassword().equals(password)) {
                d = 1;
                break;
            }
        }
        if (d == 0) {
            System.out.println("Password does not match!");
            return false;
        }

        return true;
    }

    // change Username
    public void changeUsername(Scanner scanner, ArrayList<Lecturer> lecturers) {
        String newUsername;
        boolean isValid;
        do {
            System.out.print("Enter Lecturer new Username: ");
            newUsername = scanner.nextLine().trim();
            isValid = Main.validator.userNameIsValid(newUsername, lecturers);
        } while (!isValid);

        currentLecturer.setUsername(newUsername);
        System.out.println("Change Lecturer Username Successfully!");
    }

    // change Email
    public void changeEmail(Scanner scanner, ArrayList<Lecturer> lecturers) {
        String newEmail;
        boolean isValid;
        do {
            System.out.print("Enter Lecturer new Email: ");
            newEmail = scanner.nextLine().trim();
            isValid = Main.validator.emailIsValid(newEmail, lecturers);
        } while (!isValid);

        currentLecturer.setEmail(newEmail);
        System.out.println("Change Lecturer Email Successfully!");
    }

    // change Password
    public void changePassword(Scanner scanner) {
        String newPassword;
        boolean isValid;
        do {
            System.out.print("Enter Lecturer new Password: ");
            newPassword = scanner.nextLine().trim();
            isValid = Main.validator.passIsValid(newPassword);
        } while (!isValid);

        currentLecturer.setPassword(newPassword);
        System.out.println("Change Lecturer Password Successfully!");
    }

    // change Phone Number
    public void changePhoneNumb(Scanner scanner, ArrayList<Lecturer> lecturers) {
        String phoneNumb;
        boolean isValid;
        do {
            System.out.print("Enter Lecturer new Phone Number: ");
            phoneNumb = scanner.nextLine().trim();
            isValid = Main.validator.phoneNumbIsValid(phoneNumb, lecturers);
        } while (!isValid);

        currentLecturer.setPhoneNumb(phoneNumb);
        System.out.print("Change Lecturer new Phone Number Successfully! ");
    }

    // Lecturer can see his or her Schedule
}

