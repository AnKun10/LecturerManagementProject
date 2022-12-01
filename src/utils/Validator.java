package utils;

import constant.RegexConstant;
import entity.Admin;
import entity.Lecturer;
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

    // For Admin and Lecturer
    public boolean passIsValid(String password) {
        // Password Length from 7 to 15 digits
        String passPattern = RegexConstant.PASSWORD.value;
        boolean isValid = Pattern.matches(passPattern, password);
        if (!isValid) {
            System.out.println("Invalid Password, try again!");
            return false;
        }
        return true;
    }

    // For Lecturer
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
        String emailPattern = RegexConstant.EMAIL.value;
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
            System.out.println("Invalid Email, try again!");
            return false;
        }

        return true;
    }

    public boolean phoneNumbIsValid(String phoneNumb, ArrayList<Lecturer> lecturers) {
        String phoneNumbPattern = RegexConstant.PHONENUMBER.value;
        // to register account, Phone Number cannot be available before
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getPhoneNumb().equals(phoneNumb)) {
                System.out.println("The phone is available, try again.");
                return false;
            }
        }
        // valid Phone Number + Phone Number cannot be available before
        boolean isValid = Pattern.matches(phoneNumbPattern, phoneNumb);
        if (!isValid) {
            System.out.println("Invalid Phone Number, try again!");
            return false;
        }

        return true;
    }

    // For Admin
    public boolean getName(String name) {
        String namePattern = RegexConstant.NAME.value;
        boolean isValid = Pattern.matches(namePattern, name);
        if (!isValid) {
            System.out.println("Invalid Name, try again!");
            return false;
        }
        return true;
    }

    public boolean emailIsValid4Admin(String email, ArrayList<Admin> admins) {
        // Use Regex to validate Email
        String emailPattern = RegexConstant.EMAIL.value;
        boolean isValid = Pattern.matches(emailPattern, email);
        if (!isValid) {
            System.out.println("Invalid Email, try again!");
            return false;
        }
        return true;
    }

    public boolean phoneNumbIsValid4Admin(String phoneNumb, ArrayList<Admin> admins) {
        String phoneNumbPattern = RegexConstant.PHONENUMBER.value;
        boolean isValid = Pattern.matches(phoneNumbPattern, phoneNumb);
        if (!isValid) {
            System.out.println("Invalid Phone Number, try again!");
            return false;
        }
        return true;
    }

}
