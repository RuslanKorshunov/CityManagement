package by.resliv.citymanagement.validator;

import org.springframework.stereotype.Component;

@Component("informationValidator")
public class InformationValidator extends Validator {
    private static final String INFO_REGEX;

    static {
        INFO_REGEX = "^[\\w\\W\\p{IsCyrillic}]{1,500}$";
    }

    @Override
    String getRegex() {
        return INFO_REGEX;
    }
}
