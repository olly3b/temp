package com.wahanda.forms;

import java.util.Random;

/**
 * Created by oliver on 23/10/2014.
 */
public class AccountForm {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String profileName;
    private String postcode;
    private String gender;

    public void generateTestUser() {
        String randomString = generateRandomString();

        this.email = randomString + "@test.com";
        this.firstName = "TestFirstName";
        this.lastName = "TestLastName";
        this.password = "Password5";
        this.profileName = randomString;
        this.gender = "male";
        this.postcode = "E15 2HP";
    }

    private String generateRandomString() {
        Random random = new Random();
        char[] characters = new char[9];
        StringBuilder string = new StringBuilder();
        for (char character : characters) {
            int number = random.nextInt(25) + 97;
            character = (char) number;
            string.append(character);
        }
        return string.toString();
    }

    public void setAsPasswordTestUser() {
        this.setEmail("password@test.com");
        this.setPassword("Password5");
        this.setFirstName("Password");
        this.setLastName("Test");
        this.setGender("Male");
        this.setProfileName("passwordtest");
        this.setPostcode("E15 2HP");
    }

    public void setAsEditProfileTestUser() {
        this.setEmail("editprofile@test.com");
        this.setPassword("Password5");
        this.setFirstName("Edit");
        this.setLastName("Profile");
        this.setGender("Female");
        this.setProfileName("editprofile");
        this.setPostcode("SS2 5DT");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
