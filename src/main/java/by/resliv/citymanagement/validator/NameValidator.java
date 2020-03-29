package by.resliv.citymanagement.validator;

import org.springframework.stereotype.Component;

@Component("nameValidator")
public class NameValidator extends Validator {
    private static final String NAME_REGEX;

    static {
        NAME_REGEX = "^\\p{IsCyrillic}[\\p{IsCyrillic}-]{1,18}\\p{IsCyrillic}$";
    }

    @Override
    String getRegex() {
        return NAME_REGEX;
    }
}
