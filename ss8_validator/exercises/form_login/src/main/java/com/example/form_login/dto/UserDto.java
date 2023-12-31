package com.example.form_login.dto;

import javax.validation.constraints.*;

public class UserDto {
    @NotEmpty(message = "Not Empty")
    @Size(min = 5, max = 45, message = "5->45 character")
    private String firstName;
    @NotEmpty(message = "Not Empty")
    @Size(min = 5, max = 45, message = "5->45 character")
    private String lastName;
    @NotEmpty(message = "Not Empty")
    @Pattern(regexp = "^0[0-9]{9}$", message = "Phone must have 10 number")
    private String phoneNumber;
    @Min(value = 18, message = "Age > 18")
    private int age;
    @Email
    private String email;
    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
