package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private List<Predicate<T>> predicates = new ArrayList<>();

    public final List<Predicate<T>> getPredicates() {
        return predicates;
    }

    public boolean isValid(T obj) {
        if (predicates.isEmpty()) {
            return true;
        }
        return predicates.get(predicates.size() - 1).test(obj);
    }
}
