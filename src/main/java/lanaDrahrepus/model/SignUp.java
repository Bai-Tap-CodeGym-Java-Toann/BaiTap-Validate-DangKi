package lanaDrahrepus.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SignUp implements Validator {

    private String email;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    public SignUp() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


    @Override
    public boolean supports(Class<?> clazz) {
        return SignUp.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignUp signUpTemplates = (SignUp) target;
        String phoneNumber = signUpTemplates.getPhoneNumber();
        String password = signUpTemplates.getPassword();
        String lastName = signUpTemplates.getLastName();
        String firstName = signUpTemplates.getFirstName();
        String username = signUpTemplates.getUsername();
        String email = signUpTemplates.getEmail();

        ValidationUtils.rejectIfEmpty(errors,"phoneNumber","empty");
        ValidationUtils.rejectIfEmpty(errors,"lastName","empty");
        ValidationUtils.rejectIfEmpty(errors,"firstName","empty");
        ValidationUtils.rejectIfEmpty(errors,"username","empty");
        ValidationUtils.rejectIfEmpty(errors,"email","empty");
        ValidationUtils.rejectIfEmpty(errors,"password","empty");

        if (!phoneNumber.matches("^0[0-9]{9,10}$")){
            errors.rejectValue("phoneNumber","phone.error");
        }
        if (!email.matches("^\\w{6,}@\\w+\\.(com|edu|com.vn|org|gov)")){
            errors.rejectValue("email","email.error");
        }
        if (username.length()<8){
            errors.rejectValue("username","short");
        }
        if (password.length()<8){
            errors.rejectValue("password","short");
        }
        if (firstName.length() < 3){
            errors.rejectValue("firstName","firstname.short");
        }
        if (lastName.length()<3){
            errors.rejectValue("firstName","lastname.short");
        }

    }


}
