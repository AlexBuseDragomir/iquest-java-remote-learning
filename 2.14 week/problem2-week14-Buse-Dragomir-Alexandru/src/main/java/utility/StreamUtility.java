package utility;

import java.util.Iterator;
import java.util.stream.Stream;

public class StreamUtility {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();

        Stream.Builder<T> builder = Stream.builder();

        while (iteratorFirst.hasNext() && iteratorSecond.hasNext()) {
            builder.add(iteratorFirst.next());
            builder.add(iteratorSecond.next());
        }

        while (iteratorFirst.hasNext()) {
            builder.add(iteratorFirst.next());
        }

        while (iteratorSecond.hasNext()) {
            builder.add(iteratorSecond.next());
        }

        return builder.build();
    }
}
