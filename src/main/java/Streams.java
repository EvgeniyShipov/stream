import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams<T> {
    private List<T> list;

    public Streams(List<T> list) {
        this.list = list;
    }

    public static <T> Streams<T> of(List<T> t) {
        return new Streams<T>(t);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        List<T> result = new ArrayList<T>();
        for (T i : list) {
            if (predicate.test(i)) {
                result.add(i);
            }
        }
        return new Streams<T>(result);
    }

    public <E> Streams<E> transform(Function<? super T, ? extends E> transformer) {
        List<E> result = new ArrayList<E>();
        for (T i : list) {
            result.add(transformer.apply(i));
        }

        return new Streams<E>(result);
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> key, Function<? super T, ? extends V> value) {
        Map<K, V> map = new HashMap<K, V>();
        for (int i = 0; i < list.size(); i++) {

            map.put(key.apply(list.get(i)), value.apply(list.get(i)));
        }
        return map;
    }
}
