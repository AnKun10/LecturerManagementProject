package logic;

import constant.SpecialityConstant;
import constant.TimetableConstant;
import constant.WorkPlaceConstant;

import entity.Clazz;
import main.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminFunction {
    private Clazz inputClazz(Scanner scanner) { //Input new Clazz
        String workplace = chooseWorkplace(scanner);
        String speciality = chooseSpeciality(scanner);
        String timetable = chooseTimetable(scanner);
        return new Clazz(workplace, speciality, timetable);
    }

    private Clazz chooseClazz(ArrayList<Clazz> clazzes, Scanner scanner) { //Choose a Clazz in available Clazz's List
        System.out.print("Enter a Class's id: "); //Find Clazz by Id
        int id;
        do {
            id = Main.validator.getInt(scanner);
            for (Clazz clazz : clazzes) {
                if (clazz.getId() == id) { //Successfully find Clazz
                    return clazz;
                }
            }
            //Failed to find Clazz -> Choose function
            System.out.println("Invalid Class's id, please choose a Function to continue:");
            System.out.println("1 - Retry");
            System.out.println("2 - Back to the Previous Page");
            System.out.print("Choose a function: ");
            int choice;
            do {
                choice = Main.validator.getInt(scanner);
                if (choice == 1 || choice == 2) {
                    break;
                }
                System.out.println("Invalid number, please try again!");
            } while (true);
            switch (choice) {
                case 1: //Case 1: Retry to choose
                    break;
                case 2: //Case 2: User want to go back t o the previous page -> return Clazz = null
                    return null;
            }
        } while (true);
    }

    private String chooseTimetable(Scanner scanner) {
        System.out.println("-----TIMETABLE-----");
        System.out.println("1 - TUESDAY, THURSDAY, SATURDAY (6:30 P.M. -> 9:30 P.M.)");
        System.out.println("2 - MONDAY, WEDNESDAY, FRIDAY (6:30 P.M. -> 9:30 P.M.)");
        System.out.print("Choose Timetable: ");
        int choice;
        do {
            System.out.print("Choose Timetable: ");
            choice = Main.validator.getInt(scanner);
            if (choice <= 2 && choice >= 1) {
                break;
            }
            System.out.println("Invalid number, please try again!");
        } while (true);
        String timetable = "";
        switch (choice) {
            case 1:
                timetable = TimetableConstant.ODDDAYS.value;
                break;
            case 2:
                timetable = TimetableConstant.EVENDAYS.value;
                break;
        }
        return timetable;
    }

    private String chooseWorkplace(Scanner scanner) {
        System.out.println("WORKPLACES");
        System.out.println("1 - DỊCH VỌNG HẬU");
        System.out.println("2 - NGUYỄN ĐÌNH CHIỂU");
        System.out.println("3 - TỐ HỮU");
        int choice;
        do {
            System.out.print("Choose Workplace: ");
            choice = Main.validator.getInt(scanner);
            if (choice <= 3 && choice >= 1) {
                break;
            }
            System.out.println("Invalid number, please try again!");
        } while (true);
        String workplace = "";
        switch (choice) {
            case 1:
                workplace = WorkPlaceConstant.DICHVONGHAU.value;
                break;
            case 2:
                workplace = WorkPlaceConstant.NGUYENDINHCHIEU.value;
                break;
            case 3:
                workplace = WorkPlaceConstant.TOHUU.value;
                break;
        }
        return workplace;
    }

    private String chooseSpeciality(Scanner scanner) {
        System.out.println("SPECIALITIES");
        System.out.println("1 - WEB BACK-END");
        System.out.println("2 - WEB FRONT-END");
        System.out.println("3 - DEVOPS & AWS");
        System.out.println("4 - MOBILE");
        System.out.println("5 - STEM");
        int choice;
        do {
            System.out.print("Choose Speciality: ");
            choice = Main.validator.getInt(scanner);
            if (choice <= 5 && choice >= 1) {
                break;
            }
            System.out.println("Invalid number, please try again!");
        } while (true);
        String speciality = "";
        switch (choice) {
            case 1:
                speciality = SpecialityConstant.WEBBACKEND.value;
                break;
            case 2:
                speciality = SpecialityConstant.WEBFRONTEND.value;
                break;
            case 3:
                speciality = SpecialityConstant.DEVOPSAWS.value;
                break;
            case 4:
                speciality = SpecialityConstant.MOBILE.value;
                break;
            case 5:
                speciality = SpecialityConstant.STEM.value;
                break;
        }
        return speciality;
    }

    public void displayClazz(ArrayList<Clazz> clazzes) {
        for (Clazz clazz : clazzes) {
            System.out.println(clazz);
        }
    }

    public void addClazz(ArrayList<Clazz> clazzes, Scanner scanner) { //Add new Clazz Function
        System.out.println("ADD FUNCTION");
        clazzes.add(inputClazz(scanner));
        System.out.println("Successfully add new Classes!");
    }

    public void removeClazz(ArrayList<Clazz> clazzes, Scanner scanner) {
        System.out.println("REMOVE FUNCTION");
        System.out.println("Available Classes:");
        displayClazz(clazzes);
        Clazz clazz = chooseClazz(clazzes, scanner);
        if (clazz == null) {
            return;
        }
        clazzes.remove(clazz);
        System.out.println("Successfully remove Class " + clazz.getId() + "!");
    }

    public void changeClazz(ArrayList<Clazz> clazzes, Scanner scanner) {
        System.out.println("CHANGE FUNCTION");
        System.out.println("Available Classes:");
        displayClazz(clazzes);
        Clazz clazz = chooseClazz(clazzes, scanner);
        if (clazz == null) {
            return;
        }
        System.out.println("1 - Change Workplace");
        System.out.println("2 - Change Speciality");
        System.out.println("3 - Change Timetable");
        System.out.print("Choose a function: ");
        int choice;
        do {
            choice = Main.validator.getInt(scanner);
            if (choice >= 1 && choice <= 3) {
                break;
            }
            System.out.println("Invalid number, please try again!");
        } while (true);
        switch (choice) {
            case 1:
                clazz.setWorkplace(chooseWorkplace(scanner));
                break;
            case 2:
                clazz.setSpeciality(chooseSpeciality(scanner));
                break;
            case 3:
                clazz.setTimetable(chooseTimetable(scanner));
                break;
        }
    }

}
