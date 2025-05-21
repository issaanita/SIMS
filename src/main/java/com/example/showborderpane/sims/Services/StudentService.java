package com.example.showborderpane.sims.Services;

import java.sql.SQLException;

import com.example.showborderpane.sims.Database.DBHandler;
import com.example.showborderpane.sims.Models.StudentModel;

public class StudentService {

    public static int getTotalClasses() {
        String query = "SELECT COUNT(*) FROM class;";
        return DBHandler.getCountFromDatabase(query);
    }

    public static int getTotalStudents() {
        String query = "SELECT COUNT(*) FROM students;";
        return DBHandler.getCountFromDatabase(query);
    }

    public static int getTotalProbation() {
        String query = "SELECT COUNT(*) FROM grades WHERE grade < 60;";
        return DBHandler.getCountFromDatabase(query);
    }

    public static int getTotalPenalties() {
        String query = "SELECT COUNT(*) FROM students WHERE due_date < CURDATE();";
        return DBHandler.getCountFromDatabase(query);
    }

    public static boolean registerStudent(StudentModel std) throws SQLException {

        String sql = "INSERT INTO students (first_name, last_name, father_name, mother_name, " +
                "date_of_birth, gender, email, student_phone_number, parent_phone_number, nationality, address, " +
                "student_type, graduate, disability, class_grade, registration_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE)";

        return DBHandler.executeUpdate(sql,
                std.getFirstName(),
                std.getLastName(),
                std.getFatherName(),
                std.getMotherName(),
                std.getDateOfBirth(),
                std.getGender(),
                std.getEmail(),
                std.getStudentPhoneNumber(),
                std.getParentPhoneNumber(),
                std.getNationality(),
                std.getAddress(),
                std.getStudentType(),
                std.getGraduate(),
                std.getDisability(),
                std.getClassGrade());
    }
}
