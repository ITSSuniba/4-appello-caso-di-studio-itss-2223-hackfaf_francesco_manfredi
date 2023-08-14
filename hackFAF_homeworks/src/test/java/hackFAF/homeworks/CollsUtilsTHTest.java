package hackFAF.homeworks;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.constraints.UniqueElements;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CollsUtilsTHTest {

    //Test with collections of integers
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    @Property
    void testContainsBoth(
            @ForAll @Size(value = 12) Collection< @IntRange(min = -500, max = 500) @UniqueElements Integer> coll1,
            @ForAll @Size(value = 21) Collection< @IntRange(min = -500, max = 500) @UniqueElements Integer> coll2){

        final int matchCount = 0;
        boolean expected = containsBothTest(coll1, coll2);
        boolean actual = CollsUtilsTH.containsBoth(coll1, coll2);
        assertEquals(expected, actual);

        if (expected) {
            Statistics.collect(matchCount, 1);
        }else
            Statistics.collect(matchCount, 0);
    }

    //Test with different types of elements (Integer and String)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    @Property
    void testContainsBothWithDifferentTypesOfElements(
            @ForAll @Size(value = 21) Collection<@IntRange(min = -500, max = 500) Integer> coll1,
            @ForAll @Size(value = 21) Collection<String> coll2) {

        final int matchCount = 0;
        boolean expected = containsBothTest(coll1, coll2);
        boolean actual = CollsUtilsTH.containsBoth(coll1, coll2);
        assertEquals(expected, actual);

        if (expected) {
            Statistics.collect(matchCount, 1);
        }else
            Statistics.collect(matchCount, 0);
    }

    //Test with duplicated elements
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    @Property
    void testContainsBothWithDuplicatedElements(
            @ForAll @Size(value = 21) Collection<@IntRange(min = -500, max = 500) Integer> coll1,
            @ForAll @Size(value = 21) Collection< @IntRange(min = -500, max = 500) Integer> coll2) {


        final int matchCount = 0;
        boolean expected = containsBothTest(coll1, coll2);
        boolean actual = CollsUtilsTH.containsBoth(coll1, coll2);
        assertEquals(expected, actual);

        if (expected) {
            Statistics.collect(matchCount, 1);
        }else
            Statistics.collect(matchCount, 0);
    }

    //Test with large collections
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    @Property
    void testContainsBothWithLargeCollections(
            @ForAll @Size(value = 1000) Collection<@IntRange(min = -5000, max = 5000) Integer> coll1,
            @ForAll @Size(value = 1000) Collection<@IntRange(min = -5000, max = 5000) Integer> coll2) {

        final int matchCount = 0;
        boolean expected = containsBothTest(coll1, coll2);
        boolean actual = CollsUtilsTH.containsBoth(coll1, coll2);
        assertEquals(expected, actual);

        if (expected) {
            Statistics.collect(matchCount, 1);
        }else
            Statistics.collect(matchCount, 0);
    }


    //Test with different collection implementations
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    @Property
    void testContainsBothWithDifferentCollectionImplementations(
            @ForAll @Size(value = 12) Collection<@IntRange(min = -500, max = 500) Integer> coll1,
            @ForAll @Size(value = 21) Collection <@IntRange(min = -500, max = 500) Integer> coll2){

        Collection<Integer> coll2Set = new HashSet<>(coll2);

        final int matchCount = 0;
        boolean expected = containsBothTest(coll1, coll2Set);
        boolean actual = CollsUtilsTH.containsBoth(coll1, coll2Set);
        assertEquals(expected, actual);

        if (expected) {
            Statistics.collect(matchCount, 1);
        }else
            Statistics.collect(matchCount, 0);
    }

    private boolean containsBothTest(Collection<?> coll1, Collection<?> coll2) {
        for (Object element : coll1) {
            if (coll2.contains(element)) {
                return true;
            }
        }
        for (Object element : coll2) {
            if (coll1.contains(element)) {
                return true;
            }
        }
        return false;
    }
}








