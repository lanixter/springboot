package ru.ivonin.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.ivonin.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {

            bindingResult.getFieldErrors().forEach(error ->
                    log.error("Validation error in field '{}': {}", error.getField(), error.getDefaultMessage())
            );
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
}
