package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addPredicate(value -> value != null && !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        addPredicate(value -> value == null || value.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        addPredicate(value -> value == null || value.contains(substring));
        return this;
    }

    private void addPredicate(Predicate<String> predicate) {
        getPredicates().add(predicate);
    }
}
