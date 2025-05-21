package com.example.showborderpane.sims.Models;

import java.math.BigDecimal;
import java.sql.Date;

public class TeacherModel {

    private Integer unifiedNb;
    private String الرقمآلي;
    private String الرقممالي;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String areaOfResidence;
    private String الفئة;
    private String الدرجة;
    private Date dateOfBirth;
    private String gender;
    private String email;
    private String phoneNumber;
    private String subjectSpecialization;
    private Date hireDate;
    private String employmentStatus;
    private Integer experienceYears;
    private String degreesQualifications;
    private String role;
    private String reports;
    private BigDecimal usdSalary;
    private BigDecimal lbpSalary;
    private BigDecimal حوافز;
    private BigDecimal deductions;
    private Date dateAllocated;
    private String bank;
    private byte[] receipt;

    public Integer getUnifiedNb() {
        return unifiedNb;
    }

    public void setUnifiedNb(Integer unifiedNb) {
        this.unifiedNb = unifiedNb;
    }

    public String getالرقمآلي() {
        return الرقمآلي;
    }

    public void setالرقمآلي(String الرقمآلي) {
        this.الرقمآلي = الرقمآلي;
    }

    public String getالرقممالي() {
        return الرقممالي;
    }

    public void setالرقممالي(String الرقممالي) {
        this.الرقممالي = الرقممالي;
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

    public String getAreaOfResidence() {
        return areaOfResidence;
    }

    public void setAreaOfResidence(String areaOfResidence) {
        this.areaOfResidence = areaOfResidence;
    }

    public String getالفئة() {
        return الفئة;
    }

    public void setالفئة(String الفئة) {
        this.الفئة = الفئة;
    }

    public String getالدرجة() {
        return الدرجة;
    }

    public void setالدرجة(String الدرجة) {
        this.الدرجة = الدرجة;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSubjectSpecialization() {
        return subjectSpecialization;
    }

    public void setSubjectSpecialization(String subjectSpecialization) {
        this.subjectSpecialization = subjectSpecialization;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getDegreesQualifications() {
        return degreesQualifications;
    }

    public void setDegreesQualifications(String degreesQualifications) {
        this.degreesQualifications = degreesQualifications;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

    public BigDecimal getUsdSalary() {
        return usdSalary;
    }

    public void setUsdSalary(BigDecimal usdSalary) {
        this.usdSalary = usdSalary;
    }

    public BigDecimal getLbpSalary() {
        return lbpSalary;
    }

    public void setLbpSalary(BigDecimal lbpSalary) {
        this.lbpSalary = lbpSalary;
    }

    public BigDecimal getحوافز() {
        return حوافز;
    }

    public void setحوافز(BigDecimal حوافز) {
        this.حوافز = حوافز;
    }

    public BigDecimal getDeductions() {
        return deductions;
    }

    public void setDeductions(BigDecimal deductions) {
        this.deductions = deductions;
    }

    public Date getDateAllocated() {
        return dateAllocated;
    }

    public void setDateAllocated(Date dateAllocated) {
        this.dateAllocated = dateAllocated;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public byte[] getReceipt() {
        return receipt;
    }

    public void setReceipt(byte[] receipt) {
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "unifiedNb=" + unifiedNb +
                ", الرقمآلي='" + الرقمآلي + '\'' +
                ", الرقممالي='" + الرقممالي + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", areaOfResidence='" + areaOfResidence + '\'' +
                ", الفئة='" + الفئة + '\'' +
                ", الدرجة='" + الدرجة + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", subjectSpecialization='" + subjectSpecialization + '\'' +
                ", hireDate=" + hireDate +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", experienceYears=" + experienceYears +
                ", degreesQualifications='" + degreesQualifications + '\'' +
                ", role='" + role + '\'' +
                ", reports='" + reports + '\'' +
                ", usdSalary=" + usdSalary +
                ", lbpSalary=" + lbpSalary +
                ", حوافز=" + حوافز +
                ", deductions=" + deductions +
                ", dateAllocated=" + dateAllocated +
                ", bank='" + bank + '\'' +
                '}';
    }
}
