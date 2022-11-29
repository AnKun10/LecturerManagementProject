package utils;

import entity.Lecturer;
import entity.Person;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {

    public int getInt(Scanner scanner) {
        int value = 0;
        boolean isValid = false;
        do {
            try {
                value = Integer.parseInt(scanner.nextLine());
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again");
            }
        } while( !isValid );
        return value;
    }

    public boolean userNameIsValid(String username, ArrayList<Lecturer> lecturers) {
        // to register account, username cannot be left blank
        if (username.length() == 0) {
            System.out.println("Username cannot be left blank, please try again.");
        }
        //to register another account, username cannot be available before
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getUsername().equalsIgnoreCase(username)) {
                System.out.println("The Username is available, try again.");
                return false;
            }
        }

        return true;
    }

    public boolean emailIsValid(String email, ArrayList<Lecturer> lecturers) {
        // Use Regex to validate Email
        String emailPattern =
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        // to register account, the Email cannot be available before
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getEmail().equalsIgnoreCase(email)) {
                System.out.println("The email is available, try again.");
                return false;
            }
        }
        // valid Email + Email cannot be available before
        boolean isValid = Pattern.matches(emailPattern, email);
        if (!isValid) {
            System.out.println("Email is not valid, try again.");
            return false;
        }

        return true;
    }

    public boolean passIsValid(String password) {
        // Password Length from 7 to 15 characters
        // Password has one capital character, one special character
        String passPattern = "^\\w{7,15}$";

    }
}
