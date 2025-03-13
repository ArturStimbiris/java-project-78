package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        getPredicates().add(value -> value != null);
        return this;
    }

    public NumberSchema positive() {
        getPredicates().add(value -> value == null || value > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        getPredicates().add(value -> value == null || (value >= min && value <= max));
        return this;
    }
}
