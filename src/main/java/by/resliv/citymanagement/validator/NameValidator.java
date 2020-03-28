package by.resliv.citymanagement.validator;

import org.springframework.stereotype.Component;

@Component("nameValidator")
public class NameValidator implements Validator {
    private static final String NAME_REGEX;

    static {
        NAME_REGEX = "^\\w+[\\-\\w+]*$";
    }

    @Override
    public boolean validate(String value) {
        return value.matches(NAME_REGEX);
    }
}
