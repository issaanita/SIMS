
package com.example.showborderpane.sims.Validators;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AddStdValidator {

    public static String validateStudentForm(
            TextField firstNameField,
            TextField lastNameField,
            TextField fatherNameField,
            TextField motherNameField,
            DatePicker dobPicker,
            ToggleGroup genderGroup,
            TextField emailField,
            TextField phoneField,
            RadioButton lebaneseRadio,
            ComboBox<String> nationalityComboBox,
            TextField parentPhoneField,
            ComboBox<String> disabilityComboBox,
            RadioButton graduateStudentRadio,
            RadioButton newStudentRadio,
            RadioButton transferStudentRadio,
            RadioButton newAdmitRadio,
            RadioButton oldStudentRadio,
            RadioButton continuingStudentRadio,
            RadioButton repeatingStudentRadio,
            ComboBox<String> classGradeComboBox) {

        StringBuilder errorMessages = new StringBuilder();

        String firstName = firstNameField.getText().trim();
        if (firstName.isEmpty())
            errorMessages.append("Student's first name must not be null.\n");

        String lastName = lastNameField.getText().trim();
        if (lastName.isEmpty())
            errorMessages.append("Student's last name must not be null.\n");

        String fatherName = fatherNameField.getText().trim();
        if (fatherName.isEmpty())
            errorMessages.append("Student's father's name must not be null.\n");

        String motherName = motherNameField.getText().trim();
        if (motherName.isEmpty())
            errorMessages.append("Student's mother name must not be null.\n");

        String email = emailField.getText().trim();
        if (!email.isEmpty()
                && !(email.contains("@example.com") || email.contains("@gmail.com") || email.contains("@yahoo.com"))) {
            errorMessages.append("Invalid email format. Please enter a valid email.\n");
        }

        String phone = phoneField.getText().trim();
        if (phone.isEmpty()) {
            errorMessages.append("Phone number must not be null.\n");
        } else if (lebaneseRadio.isSelected()) {
            if (!phone.matches("\\+961 \\d{2} \\d{3} \\d{3}")) {
                errorMessages.append("Lebanese phone number must follow the format: +961 XX XXX XXX\n");
            }
        } else {
            if (!phone.matches("\\d+")) {
                errorMessages.append("Phone number must contain only numbers.\n");
            }
        }

        String nationality = lebaneseRadio.isSelected() ? "Lebanese" : nationalityComboBox.getValue();
        if (nationality == null || nationality.isEmpty()) {
            errorMessages.append("Nationality must not be null.\n");
        }

        if (classGradeComboBox.getValue() == null || classGradeComboBox.getValue().isEmpty()) {
            errorMessages.append("Class grade must not be null.\n");
        }

        return errorMessages.length() > 0 ? errorMessages.toString() : null;
    }
}