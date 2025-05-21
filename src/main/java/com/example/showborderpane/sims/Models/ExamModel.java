package com.example.showborderpane.sims.Models;

public class ExamModel {

    private String examName;
    private String courseName;
    private Integer classGrade;
    private String examType;
    private java.sql.Date examDate;
    private Integer proctors;
    private Integer totalMarks;
    private Integer passingMarks;
    private String average;
    private Integer examDuration;
    private String examLocation;

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Integer classGrade) {
        this.classGrade = classGrade;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public java.sql.Date getExamDate() {
        return examDate;
    }

    public void setExamDate(java.sql.Date examDate) {
        this.examDate = examDate;
    }

    public Integer getProctors() {
        return proctors;
    }

    public void setProctors(Integer proctors) {
        this.proctors = proctors;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Integer getPassingMarks() {
        return passingMarks;
    }

    public void setPassingMarks(Integer passingMarks) {
        this.passingMarks = passingMarks;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public Integer getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(Integer examDuration) {
        this.examDuration = examDuration;
    }

    public String getExamLocation() {
        return examLocation;
    }

    public void setExamLocation(String examLocation) {
        this.examLocation = examLocation;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examName='" + examName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", classGrade=" + classGrade +
                ", examType='" + examType + '\'' +
                ", examDate=" + examDate +
                ", proctors=" + proctors +
                ", totalMarks=" + totalMarks +
                ", passingMarks=" + passingMarks +
                ", average='" + average + '\'' +
                ", examDuration=" + examDuration +
                ", examLocation='" + examLocation + '\'' +
                '}';
    }
}
