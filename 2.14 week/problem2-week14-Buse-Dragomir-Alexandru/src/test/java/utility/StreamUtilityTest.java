package utility;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StreamUtilityTest {

    @Test
    public void testIntegerZip() {
        Stream<Integer> first = Stream.of(1, 3, 5, 7, 9);
        long firstSize = Stream.of(1, 3, 5, 7, 9).count();

        Stream<Integer> second = Stream.of(2, 4, 6, 8, 10, 11, 12, 13, 14);
        long secondSize = Stream.of(2, 4, 6, 8, 10, 12, 14, 16, 18).count();

        Stream<Integer> result = StreamUtility.zip(first, second);
        Integer[] resultArray = result.toArray(Integer[]::new);

        assertThat(firstSize + secondSize, is((long)resultArray.length));

        for (int i = 0; i < resultArray.length; i++) {
            assertThat(resultArray[i], is(i + 1));
        }
    }

    @Test
    public void testStringZip() {
        Stream<String> first = Stream.of("1", "3", "5", "7", "9");
        long firstSize = Stream.of("1", "3", "5", "7", "9").count();

        Stream<String> second = Stream.of("2", "4", "6", "8", "10", "11", "12", "13", "14");
        long secondSize = Stream.of("2", "4", "6", "8", "10", "11", "12", "13", "14").count();

        Stream<String> result = StreamUtility.zip(first, second);
        String[] resultArray = result.toArray(String[]::new);

        assertThat(firstSize + secondSize, is((long)resultArray.length));

        for (int i = 0; i < resultArray.length; i++) {
            assertThat(resultArray[i], is(String.valueOf(i + 1)));
        }
    }
}