package by.resliv.citymanagement.validator;

import org.springframework.stereotype.Component;

@Component("numberValidator")
public class NumberValidator implements Validator {
    private static final String NUMBER_REGEX;

    static {
        NUMBER_REGEX = "^\\d+$";
    }

    @Override
    public boolean validate(String value) {
        return value.matches(NUMBER_REGEX);
    }
}
