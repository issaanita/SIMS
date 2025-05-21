package com.example.showborderpane.sims.Models;

public class EnrollmentModel {

    private int studentUnifiedNb;
    private int classGrade;
    private String semester;
    private java.sql.Date enrollmentDate;
    private String status;

    public int getStudentUnifiedNb() {
        return studentUnifiedNb;
    }

    public void setStudentUnifiedNb(int studentUnifiedNb) {
        this.studentUnifiedNb = studentUnifiedNb;
    }

    public int getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(int classGrade) {
        this.classGrade = classGrade;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public java.sql.Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(java.sql.Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "studentUnifiedNb=" + studentUnifiedNb +
                ", classGrade=" + classGrade +
                ", semester='" + semester + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", status='" + status + '\'' +
                '}';
    }
}
