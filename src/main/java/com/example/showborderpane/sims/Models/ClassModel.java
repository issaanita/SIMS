package com.example.showborderpane.sims.Models;

public class ClassModel {

    private int classGrade;
    private Integer promoYear;
    private Integer stdCapacity;
    private Integer homeroomTeacher;
    private String classDescription;
    private Integer classRepresentative;

    public int getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(int classGrade) {
        this.classGrade = classGrade;
    }

    public Integer getPromoYear() {
        return promoYear;
    }

    public void setPromoYear(Integer promoYear) {
        this.promoYear = promoYear;
    }

    public Integer getStdCapacity() {
        return stdCapacity;
    }

    public void setStdCapacity(Integer stdCapacity) {
        this.stdCapacity = stdCapacity;
    }

    public Integer getHomeroomTeacher() {
        return homeroomTeacher;
    }

    public void setHomeroomTeacher(Integer homeroomTeacher) {
        this.homeroomTeacher = homeroomTeacher;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public Integer getClassRepresentative() {
        return classRepresentative;
    }

    public void setClassRepresentative(Integer classRepresentative) {
        this.classRepresentative = classRepresentative;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classGrade=" + classGrade +
                ", promoYear=" + promoYear +
                ", stdCapacity=" + stdCapacity +
                ", homeroomTeacher=" + homeroomTeacher +
                ", classDescription='" + classDescription + '\'' +
                ", classRepresentative=" + classRepresentative +
                '}';
    }
}
