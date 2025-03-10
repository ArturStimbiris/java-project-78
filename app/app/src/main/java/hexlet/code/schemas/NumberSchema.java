package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        getPredicates().add(value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        getPredicates().add(value -> value instanceof Integer && (Integer) value > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        getPredicates().add(value -> value instanceof Integer && (Integer) value >= min && (Integer) value <= max);
        return this;
    }
}
