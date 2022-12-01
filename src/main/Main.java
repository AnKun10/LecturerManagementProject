package main;

import entity.Admin;
import entity.Clazz;
import entity.Lecturer;
import entity.LecturerSchedule;
import utils.Validator;

import java.util.ArrayList;

public class Main {
    public static ArrayList<LecturerSchedule> lecturerSchedules = new ArrayList<>();
    public static ArrayList<Clazz> clazzes = new ArrayList<>();
    public static ArrayList<Lecturer> lecturers = new ArrayList<>();
    public static Validator validator = new Validator();
    public static void main(String[] args) {
        // Create Admin Account
        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(new Admin("An", 18, "an", "an2122004@gmail.com", "0859015893", "02122004"));
    }
}
