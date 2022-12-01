package logic;

import constant.SpecialityConstant;
import constant.TimetableConstant;
import constant.WorkPlaceConstant;

import entity.Clazz;
import entity.Lecturer;
import entity.LecturerSchedule;
import main.Main;
import utils.Validator;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminFunction {
    //Clazz & Lecturer Shared Function
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

    //Clazz Functions
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
                case 2: //Case 2: User want to go back to the previous page -> return Clazz = null
                    return null;
            }
        } while (true);
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

    //Lecturer Functions
    private Lecturer chooseLecturer(ArrayList<Lecturer> lecturers, Scanner scanner) {
        System.out.print("Enter a Lecturer's id: "); //Find Clazz by Id
        int id;
        do {
            id = Main.validator.getInt(scanner);
            for (Lecturer lecturer : lecturers) {
                if (lecturer.getId() == id) { //Successfully find Clazz
                    return lecturer;
                }
            }
            //Failed to find Clazz -> Choose function
            System.out.println("Invalid Lecturer's id, please choose a Function to continue:");
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
                case 2: //Case 2: User want to go back to the previous page -> return Lecturer = null
                    return null;
            }
        } while (true);
    }

    private void displayLecturer(ArrayList<Lecturer> lecturers) {
        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer);
        }
    }

    public void removeLecturer(ArrayList<Lecturer> lecturers, Scanner scanner) {
        System.out.println("REMOVE FUNCTION");
        System.out.println("Available Lecturers:");
        displayLecturer(lecturers);
        Lecturer lecturer = chooseLecturer(lecturers, scanner);
        if (lecturer == null) {
            return;
        }
        lecturers.remove(lecturer);
        System.out.println("Successfully remove Lecturer " + lecturer.getId() + "!");
    }

    public void addLecturerSchedule(ArrayList<Lecturer> lecturers, ArrayList<Clazz> clazzes, Scanner scanner) {
        System.out.println("SCHEDULE FUNCTION");
        System.out.println("Available Lecturers:");
        displayLecturer(lecturers); //Display Lecturers List
        Lecturer lecturer = chooseLecturer(lecturers, scanner); //Select a lecturer
        if (lecturer == null) { //Lecturer == null <=> Admin want to come back to the previous page
            return;
        }
        System.out.println("Available Classes:");
        displayClazz(clazzes); //Display Classes List
        int clazzNumb;
        do {
            System.out.print("Enter number of Classes for Lecturer " + lecturer.getName() + "(at most 2 Classes/Lecturer): ");
            clazzNumb = Main.validator.getInt(scanner);
            if (clazzNumb==1||clazzNumb==2){
                break;
            }
            System.out.println("Invalid number of Classes, please choose a Function to continue:");
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
                case 2: //Case 2: User want to go back to the previous page -> return
                    return;
            }
        } while (true);
        ArrayList<Clazz> clazzes4Lecturer = new ArrayList<>(); //Classes that the Selected Lecturer will teach
        for (int i = 0; i < clazzNumb; i++) {
            Clazz clazz = chooseClazz(clazzes, scanner); //Select Class
            if (clazz == null){ //Clazz == null <=> Admin want to come back to the previous page
                return;
            }
            if (clazz.isAssign()){ //Retry if the Class has been assigned to another Lecturer
                System.out.println("Class "+clazz.getId()+" has been assigned, please try again!");
                i--;
                continue;
            }
            if (i==1 && clazz.getTimetable().equals(clazzes4Lecturer.get(0).getTimetable())){ //Retry if the Lecturer is assigned a Class with the same Timetable as his/her present Classes
                System.out.println("Lecturer "+lecturer.getName()+" has already been assigned a Class with the same Timetable!");
                System.out.println("Please try again!");
                i--;
                continue;
            }
            clazzes4Lecturer.add(clazz); //Successfully assigned a Class to a Lecturer
            clazz.setAssign(true);
            System.out.println("Successfully assigned Class "+clazz.getId()+" to Lecturer "+lecturer.getName()+"!");
        }
        Main.lecturerSchedules.add(new LecturerSchedule(lecturer, clazzes4Lecturer));
    }

}
