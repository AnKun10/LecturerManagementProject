package logic;

import constant.SpecialityConstant;
import constant.TimetableConstant;
import constant.WorkPlaceConstant;

import entity.Clazz;
import main.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminFunction {
    private Clazz inputClazz(Scanner scanner) {
        String workplace = chooseWorkplace(scanner);
        String speciality = chooseSpeciality(scanner);
        String timetable = chooseTimetable(scanner);
        return new Clazz(workplace, speciality, timetable);
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

    public void addClazz(ArrayList<Clazz> clazzes, Scanner scanner) {
        System.out.print("Enter number of new Classes: ");
        int numb;
        do {
            numb = Main.validator.getInt(scanner);
            if (numb > 0) {
                break;
            }
            System.out.println("Invalid number, please try again!");
        } while (true);
        for (int i = 0; i < numb; i++) {
            clazzes.add(inputClazz(scanner));
        }
    }

}
