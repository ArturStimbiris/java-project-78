package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        addValidation(value -> value > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addValidation(value -> value >= min && value <= max);
        return this;
    }
}
