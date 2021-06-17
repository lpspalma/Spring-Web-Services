package com.teste.thymeleaf;

public class AddUserModel {
    private String username;
    private String password;
    private String repeatPassword;
    private String title;
    private String firstName;
    private String secondName;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String zip;
    private String country;

    public AddUserModel(String name, String password, String repeatPassword, String title, String firstName, String secondName, String address1, String address2, String address3, String address4, String zip, String country) {
        this.username = name;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.title = title;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.address4 = address4;
        this.zip = zip;
        this.country = country;
    }

    public AddUserModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setusername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
