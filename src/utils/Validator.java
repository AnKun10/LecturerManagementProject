package utils;

import java.util.Scanner;

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

}
