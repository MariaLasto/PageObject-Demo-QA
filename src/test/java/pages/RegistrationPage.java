package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private Calendar calendar = new Calendar();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String TITLE_TEXT = "Student Registration Form";
    private final String IMG_FOLDER = "images/";

    private SelenideElement
            lastNameInput  = $("#lastName"),//так можно сделать, если несколько раз используется переменная в разных методах
            firstNameInput  = $("#firstName"),//чтобы скопировать строку можно нажать ctrl+D;
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            currentAddressInput = $("currentAddress"),
            userSubjectsInput = $("#subjectsInput"),
            userHobbiesChoice = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail (String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender (String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setMobileNumber (String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate (String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day,month,year);
        return this;
    }

    public RegistrationPage setSubject (String value) {
        userSubjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby (String value) {
        userHobbiesChoice.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUploadPicture (String value) {
        pictureUpload.uploadFromClasspath(IMG_FOLDER + value);
        return this;
    }

    public RegistrationPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String value1, String value2) {
        stateDropdown.click();
        stateDropdown.$(byText(value1)).click();
        cityDropdown.click();
        cityDropdown.$(byText(value2)).click();
        return this;
    }

    public RegistrationPage pressSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyRegistrationModalAppears () {
        registrationResultsModal.registrationResultAppears();
        return this;
    }

    public RegistrationPage verifyModalTableResult (String key, String value) {
        registrationResultsModal.modalTableResult(key, value);
        return this;
    }
}
