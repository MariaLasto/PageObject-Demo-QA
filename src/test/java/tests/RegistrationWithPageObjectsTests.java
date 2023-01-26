package tests;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        String userName = "Alex";
        String lastName = "Egorov";
        String email = "ma@h.ru";
        String gender = "Other";
        String mobileNumber = "0123456789";
        String dayOfBirth = "26";
        String monthOfBirth = "January";
        String yearOfBirth = "2023";
        String subjects = "History";
        String hobbies = "Reading";
        String currentAddress = "as 1-1";
        String pictureLoaded = "test-image.jpg";
        String state = "NCR";
        String city = "Delhi";



        registrationPage.openPage()
                .setFirstName(userName) //можно для каждого случая прописать  registrationPage.setFirstName(userName);
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobileNumber(mobileNumber)
                .setBirthDate(dayOfBirth,monthOfBirth,yearOfBirth)
                .setSubject(subjects)
                .setHobby(hobbies)
                .setUploadPicture(pictureLoaded)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .pressSubmit();


        registrationPage.verifyRegistrationModalAppears()
                        .verifyModalTableResult("Student name", userName + " " + lastName)
                        .verifyModalTableResult("Student Email", email)
                        .verifyModalTableResult("Gender", gender)
                        .verifyModalTableResult("Mobile", mobileNumber)
                        .verifyModalTableResult("Date of Birth", dayOfBirth+ " " + monthOfBirth + "," + yearOfBirth)
                        .verifyModalTableResult("Subjects", subjects)
                        .verifyModalTableResult("Hobbies", hobbies)
                        .verifyModalTableResult("Picture", pictureLoaded)
                        .verifyModalTableResult("Address", currentAddress)
                        .verifyModalTableResult("State and City", state + " " + city);


    }

}
