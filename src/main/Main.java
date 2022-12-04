package main;

import constant.WorkPlaceConstant;
import entity.Admin;
import entity.Clazz;
import entity.Lecturer;
import entity.LecturerSchedule;
import logic.SharedFunction;
import utils.Validator;
import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static SharedFunction sharedFunction = new SharedFunction();
    public static ArrayList<LecturerSchedule> lecturerSchedules = new ArrayList<>();
    public static ArrayList<Clazz> clazzes = new ArrayList<>();
    public static ArrayList<Lecturer> lecturers = new ArrayList<>();
    public static Validator validator = new Validator();
    public static void main(String[] args) {
        // Create Admin Account
        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(new Admin("An", 18, "an", "an2122004@gmail.com", "0859015893", "02122004"));
        admins.add(new Admin("Tâm", 18, "tam", "tam2303@gmail", "0813815263", "23032004"));
        for (Clazz clazz : clazzes) {
            Vector vectorRow = new Vector();
            if (clazz.getLecturer() == null){
                vectorRow.add(clazz.getId());
                vectorRow.add("");
                vectorRow.add(clazz.getSpeciality());
                vectorRow.add(clazz.getName());
                vectorRow.add(clazz.getSchedule());

            }
        }
    }
}
