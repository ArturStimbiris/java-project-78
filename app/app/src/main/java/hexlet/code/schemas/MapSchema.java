package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema() {
        super();
    }

    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int size) {
        addValidation(map -> map.size() == size);
        return this;
    }
}
