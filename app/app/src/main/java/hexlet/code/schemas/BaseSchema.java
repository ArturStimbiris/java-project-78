package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private List<Predicate<T>> predicates = new ArrayList<>();

    public final List<Predicate<T>> getPredicates() {
        return predicates;
    }

    public final boolean isValid(T obj) {
        return predicates.stream().allMatch(v -> v.test(obj));
    }
}
