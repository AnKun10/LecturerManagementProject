package logic;

import main.Main;

import java.util.Scanner;

public class RegisterFunction {

    public void registerFunction(Scanner scanner) {
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
        registerFunctionLogic(decentralization, scanner); // switch case
    }

    private void registerFunctionLogic(int decentralization, Scanner scanner) {
        switch (decentralization) {
            case 1:
                registerFunctionAsAdmin(scanner);
                break;
            case 2:
                registerFunctionAsLecturer(scanner);
                break;
        }
    }

    private void registerFunctionAsLecturer(Scanner scanner) {

    }

    private void registerFunctionAsAdmin(Scanner scanner) {
    }


}
