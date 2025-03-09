package hexlet.code.schemas;

import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private boolean isRequired = false;
    private Predicate<T> validationRules = value -> true;

    public BaseSchema<T> required() {
        this.isRequired = true;
        return this;
    }

    protected void addValidation(Predicate<T> rule) {
        this.validationRules = this.validationRules.and(rule);
    }

    public boolean isValid(T value) {
        if (value == null) {
            return !isRequired;
        }
        return validationRules.test(value);
    }
}
