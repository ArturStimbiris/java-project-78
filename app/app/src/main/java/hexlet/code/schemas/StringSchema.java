package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        getPredicates().add(value -> value instanceof String && !((String) value).isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        getPredicates().add(value -> value instanceof String && ((String) value).length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        getPredicates().add(value -> value instanceof String && ((String) value).contains(substring));
        return this;
    }
}
