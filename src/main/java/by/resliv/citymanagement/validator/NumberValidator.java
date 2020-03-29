package by.resliv.citymanagement.validator;

import org.springframework.stereotype.Component;

@Component("numberValidator")
public class NumberValidator extends Validator {
    private static final String NUMBER_REGEX;

    static {
        NUMBER_REGEX = "^\\d+$";
    }

    @Override
    String getRegex() {
        return NUMBER_REGEX;
    }
}
