package com.example.showborderpane.sims.Models;

import java.math.BigDecimal;

public class GradesModel {

    private String courseName;
    private String examName;
    private BigDecimal grade;
    private String remarks;
    private java.sql.Date dateGraded;
    private Integer gradedBy;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public java.sql.Date getDateGraded() {
        return dateGraded;
    }

    public void setDateGraded(java.sql.Date dateGraded) {
        this.dateGraded = dateGraded;
    }

    public Integer getGradedBy() {
        return gradedBy;
    }

    public void setGradedBy(Integer gradedBy) {
        this.gradedBy = gradedBy;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "courseName='" + courseName + '\'' +
                ", examName='" + examName + '\'' +
                ", grade=" + grade +
                ", remarks='" + remarks + '\'' +
                ", dateGraded=" + dateGraded +
                ", gradedBy=" + gradedBy +
                '}';
    }
}