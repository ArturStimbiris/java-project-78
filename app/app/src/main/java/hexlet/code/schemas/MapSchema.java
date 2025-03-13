package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema required() {
        getPredicates().add(v -> v != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        getPredicates().add(v -> v != null && v.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        getPredicates().add(v -> checkMap((Map<?, ?>) v, schemas));
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
