package com.teste.thymeleaf;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AddUSerModelValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return AddUserModel.class.equals(aClass);
    }

    @Override
    public void validate(Object user, Errors e) {
        AddUserModel addUserModel = (AddUserModel) user;
        if(!(addUserModel.getPassword().equals(addUserModel.getRepeatPassword()))){
            e.rejectValue("repeatPassword","PasswordDontMatch");
        }
    }
}
