package by.resliv.citymanagement.validator;

public abstract class Validator {
    public final boolean validate(String value) {
        return value.matches(getRegex()) &&
                value != null;
    }

    abstract String getRegex();
}
