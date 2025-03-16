package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        this.required = true;
        setPredicate("required", value -> !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        setPredicate("minLength", value -> value.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        setPredicate("contains", value -> value.contains(substring));
        return this;
    }
}
