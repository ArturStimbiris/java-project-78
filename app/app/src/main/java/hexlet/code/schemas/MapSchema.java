package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        this.required = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        setPredicate("sizeof", v -> v.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        setPredicate("shape", v -> checkMap((Map<?, ?>) v, schemas));
        return this;
    }

    <T> boolean checkMap(Map<?, ?> v, Map<String, BaseSchema<T>> schemas) {
        for (var entry : schemas.entrySet()) {
            var key = entry.getKey();
            var schema = entry.getValue();
            if (!schema.isValid((T) v.get(key))) {
                return false;
            }
        }
        return true;
    }
}
