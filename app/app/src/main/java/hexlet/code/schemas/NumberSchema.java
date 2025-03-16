package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        this.required = true;
        return this;
    }

    public NumberSchema positive() {
        setPredicate("positive", value -> value > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        setPredicate("range", value -> (value >= min && value <= max));
        return this;
    }
}
