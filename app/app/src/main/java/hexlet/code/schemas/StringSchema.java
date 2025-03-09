package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        super();
    }

    public StringSchema required() {
        super.required();
        addValidation(value -> !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        addValidation(value -> value.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        addValidation(value -> value.contains(substring));
        return this;
    }
}
