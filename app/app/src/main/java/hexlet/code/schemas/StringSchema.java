package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {

    private Predicate<String> requiredPredicate = value -> true;
    private Predicate<String> minLengthPredicate = value -> true;
    private Predicate<String> containsPredicate = value -> true;

    public StringSchema required() {
        requiredPredicate = value -> value != null && !value.isEmpty();
        return this;
    }

    public StringSchema minLength(int length) {
        minLengthPredicate = value -> value == null || value.length() >= length;
        return this;
    }

    public StringSchema contains(String substring) {
        containsPredicate = value -> value == null || value.contains(substring);
        return this;
    }

    @Override
    public boolean isValid(String value) {
        return requiredPredicate.test(value)
                && minLengthPredicate.test(value)
                && containsPredicate.test(value);
    }
}
