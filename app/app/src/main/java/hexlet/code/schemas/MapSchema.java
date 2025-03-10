package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        getPredicates().add(v -> v instanceof Map<?, ?>);
        return this;
    }

    public MapSchema sizeof(int size) {
        getPredicates().add(v -> ((Map<?, ?>) v).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        getPredicates().add(v -> checkMap((Map<?, ?>) v, schemas));
        return this;
    }

    boolean checkMap(Map<?, ?> v, Map<?, BaseSchema> sch) {
        for (var x : sch.entrySet()) {
            var k = x.getKey();
            var value = x.getValue();
            if (!value.isValid(v.get(k))) {
                return false;
            }
        }
        return true;
    }
}
