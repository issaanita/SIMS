package com.example.showborderpane.sims.Models;

import java.util.Date;

public class StudentModel {

    private int stdUnifiedNb;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private Date dateOfBirth;
    private String gender;
    private String email;
    private String studentPhoneNumber;
    private String parentPhoneNumber;
    private String nationality;
    private byte[] residencyDocument;
    private byte[] previousYearGrade;
    private String address;
    private String studentType;
    private Date firstEnrollmentDate;
    private Date registrationDate;
    private String disability;
    private Boolean graduate;
    private Integer classGrade;
    private Integer teacherName;
    private String reports;
    private Double tuitionFee;
    private Double transportationFee;
    private Double siblingDiscount;
    private Date dueDate;
    private Double penaltyFee;
    private String paymentMethod;
    private Date datePaid;
    private byte[] finReceipt;

    public int getStdUnifiedNb() {
        return stdUnifiedNb;
    }

    public void setStdUnifiedNb(int stdUnifiedNb) {
        this.stdUnifiedNb = stdUnifiedNb;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public byte[] getResidencyDocument() {
        return residencyDocument;
    }

    public void setResidencyDocument(byte[] residencyDocument) {
        this.residencyDocument = residencyDocument;
    }

    public byte[] getPreviousYearGrade() {
        return previousYearGrade;
    }

    public void setPreviousYearGrade(byte[] previousYearGrade) {
        this.previousYearGrade = previousYearGrade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public Date getFirstEnrollmentDate() {
        return firstEnrollmentDate;
    }

    public void setFirstEnrollmentDate(Date firstEnrollmentDate) {
        this.firstEnrollmentDate = firstEnrollmentDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public Boolean getGraduate() {
        return graduate;
    }

    public void setGraduate(Boolean graduate) {
        this.graduate = graduate;
    }

    public Integer getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Integer classGrade) {
        this.classGrade = classGrade;
    }

    public Integer getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(Integer teacherName) {
        this.teacherName = teacherName;
    }

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

    public Double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(Double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public Double getTransportationFee() {
        return transportationFee;
    }

    public void setTransportationFee(Double transportationFee) {
        this.transportationFee = transportationFee;
    }

    public Double getSiblingDiscount() {
        return siblingDiscount;
    }

    public void setSiblingDiscount(Double siblingDiscount) {
        this.siblingDiscount = siblingDiscount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(Double penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }

    public byte[] getFinReceipt() {
        return finReceipt;
    }

    public void setFinReceipt(byte[] finReceipt) {
        this.finReceipt = finReceipt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdUnifiedNb=" + stdUnifiedNb +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", studentPhoneNumber='" + studentPhoneNumber + '\'' +
                ", parentPhoneNumber='" + parentPhoneNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                ", address='" + address + '\'' +
                ", studentType='" + studentType + '\'' +
                ", firstEnrollmentDate=" + firstEnrollmentDate +
                ", registrationDate=" + registrationDate +
                ", disability='" + disability + '\'' +
                ", graduate=" + graduate +
                ", classGrade=" + classGrade +
                ", teacherName=" + teacherName +
                ", reports='" + reports + '\'' +
                ", tuitionFee=" + tuitionFee +
                ", transportationFee=" + transportationFee +
                ", siblingDiscount=" + siblingDiscount +
                ", dueDate=" + dueDate +
                ", penaltyFee=" + penaltyFee +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", datePaid=" + datePaid +
                '}';
    }
}
