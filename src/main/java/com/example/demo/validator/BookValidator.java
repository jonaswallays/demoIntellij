package com.example.demo.validator;

import com.example.demo.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Book.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbin", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "authors", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishDate", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publisher", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stock", "msg.field.required");
    }
}
