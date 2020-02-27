package ru.shaitanshamma.entities.dot.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ru.shaitanshamma.services.ClientService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailNotRegisteredValidator implements ConstraintValidator<EmailNotRegistered, String> {

    private final ClientService userService;

    @Autowired
    public EmailNotRegisteredValidator(ClientService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(EmailNotRegistered constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !userService.existsUserByEmail(value);
    }
}
