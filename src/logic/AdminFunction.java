package logic;

import entity.Admin;
import entity.Clazz;
import entity.Lecturer;
import entity.LecturerSchedule;
import main.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminFunction {
    //Clazz Functions
    private Clazz inputClazz(Scanner scanner) { //Input new Clazz
        String workplace = Main.sharedFunction.chooseWorkplace(scanner);
        String speciality = Main.sharedFunction.chooseSpeciality(scanner);
        String timetable = Main.sharedFunction.chooseTimetable(scanner);
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
                clazz.setWorkplace(Main.sharedFunction.chooseWorkplace(scanner));
                break;
            case 2:
                clazz.setSpeciality(Main.sharedFunction.chooseSpeciality(scanner));
                break;
            case 3:
                clazz.setTimetable(Main.sharedFunction.chooseTimetable(scanner));
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

    public void displayLecturer(ArrayList<Lecturer> lecturers) {
        System.out.println("DISPLAY LECTURERS FUNCTION");
        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer);
        }
    }

    public void displayLecturerSchedule(ArrayList<LecturerSchedule> lecturerSchedules) {
        System.out.println("DISPLAY LECTURERS' SCHEDULE FUNCTION");
        for (LecturerSchedule lecturerSchedule : lecturerSchedules) {
            System.out.println(lecturerSchedule);
        }
    }

    public void removeLecturer(ArrayList<Lecturer> lecturers, Scanner scanner) {
        System.out.println("REMOVE LECTURER FUNCTION");
        System.out.println("Available Lecturers:");
        Lecturer lecturer = chooseLecturer(lecturers, scanner);
        if (lecturer == null) {
            return;
        }
        lecturers.remove(lecturer);
        System.out.println("Successfully remove Lecturer " + lecturer.getId() + "!");
    }

    //Case 1: Assigned Suitable Class ?
    private boolean isAssignableLecturerSchedule(LecturerSchedule lecturerSchedule, Clazz clazz) {
        if (clazz.isAssign()) {
            System.out.println("Class " + clazz.getId() + " has been assigned!");
            return false;
        }
        if (lecturerSchedule.getClazzes().size() == 1) {
            if (lecturerSchedule.getClazzes().get(0).getTimetable().equals(clazz.getTimetable())) {
                System.out.println("Lecturer " + lecturerSchedule.getLecturer().getName() + " has been assigned on " + clazz.getTimetable());
                return false;
            }
            if (!lecturerSchedule.getLecturer().getSpeciality().equals(clazz.getSpeciality())) {
                System.out.println("Lecturer " + lecturerSchedule.getLecturer().getName() + "'s speciality isn't suitable for Class " + clazz.getId());
                return false;
            }
            if (!lecturerSchedule.getLecturer().getWorkplace().equals(clazz.getWorkplace())) {
                System.out.println("Lecturer " + lecturerSchedule.getLecturer().getName() + "'s workplace isn't suitable for Class " + clazz.getId());
                return false;
            }
        }
        return true;
    }

    //Case 2: Assigned the max Classes ?
    private boolean isAssignableLecturerSchedule(LecturerSchedule lecturerSchedule) {
        if (lecturerSchedule.getClazzes().size() == 2) {
            System.out.println("Lecturer " + lecturerSchedule.getLecturer().getName() + " has been assigned the maximum classes!");
            return false;
        }
        return true;
    }

    public void addLecturerSchedule(ArrayList<LecturerSchedule> lecturerSchedules, ArrayList<Lecturer> lecturers, ArrayList<Clazz> clazzes, Scanner scanner) {
        System.out.println("ADD LECTURER SCHEDULE FUNCTION");
        System.out.println("Available Lecturers:");
        Lecturer lecturer;
        boolean isAssigned = false;
        do {
            lecturer = chooseLecturer(lecturers, scanner); //Select a lecturer
            boolean isFreeLecturer = true; //The selected Lecturer is not scheduled
            if (lecturer == null) { //Lecturer == null <=> Admin want to come back to the previous page
                return;
            }
            for (LecturerSchedule lecturerSchedule : lecturerSchedules) {
                if (lecturerSchedule.getLecturer().getId() == lecturer.getId()) { //Case 1: Select a Lecturer that already teach 1 Class
                    isFreeLecturer = false;
                    if (!isAssignableLecturerSchedule(lecturerSchedule)) { //The Lecturer has been assigned the max Classes
                        break;
                    }
                    do { //The Lecturer has been assigned 1 Class
                        isAssigned = false;
                        Clazz clazz = chooseClazz(clazzes, scanner); //Select a Class
                        if (clazz == null) {
                            return;
                        }
                        if (isAssignableLecturerSchedule(lecturerSchedule, clazz)) { //The selected Class is suitable for the Lecturer -> Assign
                            lecturerSchedule.getClazzes().add(clazz);
                            clazz.setAssign(true);
                            System.out.println("Successfully assigned Class " + clazz.getId() + " to Lecturer " + lecturer.getName() + "!");
                            isAssigned = true; //Successfully Assign Class
                        }
                        if (isAssigned) {
                            break;
                        }
                        System.out.println("Please choose another Class!");
                    } while (true);
                }
            }
            if (isAssigned) {
                break;
            }
            if (isFreeLecturer) { //Case 2: Select a Free Lecturer
                addLecturerSchedule4FreeLecturer(lecturerSchedules, clazzes, lecturer, scanner); //Assign Class for that Lecturer
                break;
            }
            System.out.println("Please choose another Lecturer!");
        } while (true);
    }

    private void addLecturerSchedule4FreeLecturer(ArrayList<LecturerSchedule> lecturerSchedules, ArrayList<Clazz> clazzes, Lecturer lecturer, Scanner scanner) {
        int clazzNumb;
        do {
            System.out.print("Enter number of Classes to assign to Lecturer " + lecturer.getName() + " (at most 2 Classes/Lecturer): ");
            clazzNumb = Main.validator.getInt(scanner);
            if (clazzNumb == 1 || clazzNumb == 2) {
                break;
            }
            System.out.println("Invalid number, please try again!");
        } while (true);
        ArrayList<Clazz> clazzes1 = new ArrayList<>();
        LecturerSchedule lecturerSchedule = new LecturerSchedule(lecturer, clazzes1);
        for (int i = 0; i < clazzNumb; i++) {
            Clazz clazz = chooseClazz(clazzes, scanner);
            if (clazz == null) {
                return;
            }
            if (!isAssignableLecturerSchedule(lecturerSchedule, clazz)) {
                System.out.println("Please choose another Class!");
                i--;
                continue;
            }
            lecturerSchedule.getClazzes().add(clazz);
            System.out.println("Successfully assign Class "+clazz.getId()+" to Lecturer "+lecturer.getName()+"!");
        }
    }


    // Security and Privacy Function
    private Admin currentAdmin;

    // Login
    public boolean loginAsAdmin(Scanner scanner, ArrayList<Admin> admins) {
        String username;
        String password;

        System.out.println("Enter Admin Information for Login");
        int d = 0;
        // valid username already exits in the list or not
        do {
            System.out.print("Enter Admin Username: ");
            username = scanner.nextLine().trim();
            for (Admin admin : admins) {
                if (admin.getUsername().equals(username)) {
                    d = 1;
                    break;
                }
            }
            if (d == 0) {
                System.out.println("Admin Username is not available, try again!");
            }
        } while (d == 0);
        // valid whether password matches username you have just entered or not
        System.out.print("Enter Admin Password: ");
        password = scanner.nextLine().trim();
        d = 0;
        for (Admin admin : admins) {
            currentAdmin = admin;
            if (currentAdmin.getUsername().equals(username) && currentAdmin.getPassword().equals(password)) {
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
    public void changeUsername(Scanner scanner, ArrayList<Admin> admins) {
        String newUsername;
        boolean isValid;
        do {
            System.out.print("Enter Admin new Username: ");
            newUsername = scanner.nextLine().trim();
            isValid = Main.validator.getName(newUsername);
        } while (!isValid);

        currentAdmin.setUsername(newUsername);
        System.out.println("Change Admin Username Successfully!");
    }

    // change Email
    public void changeEmail(Scanner scanner, ArrayList<Admin> admins) {
        String newEmail;
        boolean isValid;
        do {
            System.out.print("Enter Admin new Email: ");
            newEmail = scanner.nextLine().trim();
            isValid = Main.validator.emailIsValid4Admin(newEmail, admins);
        } while (!isValid);

        currentAdmin.setEmail(newEmail);
        System.out.println("Change Admin Email Successfully!");
    }

    // change Password
    public void changePassword(Scanner scanner) {
        String newPassword;
        boolean isValid;
        do {
            System.out.print("Enter Admin new Password: ");
            newPassword = scanner.nextLine().trim();
            isValid = Main.validator.passIsValid(newPassword);
        } while (!isValid);

        currentAdmin.setPassword(newPassword);
        System.out.println("Change Lecturer Password Successfully!");
    }

    // change Phone Number
    public void changePhoneNumb4Admin(Scanner scanner, ArrayList<Admin> admins) {
        String phoneNumb;
        boolean isValid;
        do {
            System.out.print("Enter Admin new Phone Number: ");
            phoneNumb = scanner.nextLine().trim();
            isValid = Main.validator.phoneNumbIsValid4Admin(phoneNumb, admins);
        } while (!isValid);

        currentAdmin.setPhoneNumb(phoneNumb);
        System.out.print("Change Admin new Phone Number Successfully! ");
    }
}
