package logic;

import entity.Admin;
import entity.Lecturer;
import java.util.ArrayList;
import java.util.Scanner;

public class SharedFunction {

    private Lecturer currentLecturer;
    private Admin currentAdmin;
    // Login
    public boolean login(Scanner scanner, ArrayList<Lecturer> lecturers, ArrayList<Admin> admins) {
        String username;
        String password;

        System.out.println("Enter Information for Login");
        int d = 0;
        // valid username already exits in the list or not
        do {
            System.out.print("Enter Username: ");
            username = scanner.nextLine().trim();
            // Lecturer
            for (Lecturer lecturer : lecturers) {
                if (lecturer.getUsername().equals(username)) {
                    d = 1;
                    break;
                }
            }
            // Admin
            for (Admin admin : admins) {
                if (admin.getUsername().equals(username)) {
                    d = 1;
                    break;
                }
            }

            if (d == 0) {
                System.out.println("Username is not available, try again");
            }
        } while (d == 0);

        System.out.print("Enter Password: ");
        password = scanner.nextLine().trim();
        //valid whether password matches username you have just entered
        d = 0;
        for (int i = 0; i < lecturers.size(); i++) {
            currentLecturer = lecturers.get(i);
            if (currentLecturer.getUsername().equals(username) && currentLecturer.getPassword().equals(password)) {
                d = 1;
                break;
            }
        }

        for (int i = 0; i < admins.size(); i++) {
            currentAdmin = admins.get(i);
            if (currentAdmin.getUsername().equals(username) && currentAdmin.getPassword().equals(password)) {
                d = 1;
                break;
            }
        }

        if (d == 0) {
            System.out.println("Password does not match!");
            return false;
        }

        System.out.println("Login Successfully!");
        System.out.println("\"٩(◕‿◕｡)۶Congratulation \"" + username);
        return true;
    }

    // change Username
    public void changeUsername(Scanner scanner, ArrayList<Lecturer> lecturers, ArrayList<Admin> admins) {
        String newUsername;

    }
    // change Email

    // change Phone Number
    // change Password
}
