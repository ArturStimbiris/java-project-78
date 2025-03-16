package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private Map<String, Predicate<T>> predicates = new HashMap<>();
    protected boolean required;

    public final Map<String, Predicate<T>> getPredicates() {
        return predicates;
    }

    protected final void setPredicate(String key, Predicate<T> predicate) {
        predicates.put(key, predicate);
    }


    public final boolean isValid(T obj) {
        if (!required && obj == null) {
            return true;
        }
        if (required && obj == null) {
            return false;
        }
        return predicates.values().stream().allMatch(predicate -> predicate.test(obj));
    }
}
