package logic;

import entity.Lecturer;
import main.Main;
import java.util.ArrayList;
import java.util.Scanner;

public class LecturerFunction {

    // Register information for Lecturer
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

    // Lecturer can see his or her Schedule

}
