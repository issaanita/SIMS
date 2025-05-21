package com.example.showborderpane.sims.Models;

public class CourseModel {

    private String courseName;
    private String description;
    private String language;
    private Integer classGrade;
    private Integer teacher;
    private String prerequisiteCourses;
    private String courseType;

    // Getters and Setters

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Integer classGrade) {
        this.classGrade = classGrade;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public String getPrerequisiteCourses() {
        return prerequisiteCourses;
    }

    public void setPrerequisiteCourses(String prerequisiteCourses) {
        this.prerequisiteCourses = prerequisiteCourses;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", classGrade=" + classGrade +
                ", teacher=" + teacher +
                ", prerequisiteCourses='" + prerequisiteCourses + '\'' +
                ", courseType='" + courseType + '\'' +
                '}';
    }
}
