package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        getPredicates().add(value -> value != null && !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        getPredicates().add(value -> value == null || value.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        getPredicates().add(value -> value == null || value.contains(substring));
        return this;
    }
}
