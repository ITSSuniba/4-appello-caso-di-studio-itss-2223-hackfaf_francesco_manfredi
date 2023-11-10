package hackFAF.homeworks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CollsUtilsFHTest {

    @Test
    void oneCollIsEmpty(){
        Collection<String> coll1 = Collections.emptyList();
        Collection<String> coll2 = Arrays.asList("a", "b", "c");
        assertFalse(CollsUtilsFH.containsBoth(coll1, coll2)); //T2

        Collection<String> coll3 = Arrays.asList("a", "b", "c");
        Collection<String> coll4 = Collections.emptyList();
        assertFalse(CollsUtilsFH.containsBoth(coll3, coll4)); //T4
    }

    @Test
    void oneCollIsNull(){
        Collection<Integer> coll1 = null;
        Collection<Integer> coll2 = Arrays.asList(1,2,3);
        assertThrows(NullPointerException.class, ()-> CollsUtilsFH.containsBoth(coll1,coll2)); //T1

        Collection<Integer> coll3 = Arrays.asList(1,2,3);
        Collection<Integer> coll4 = null;
        assertThrows(NullPointerException.class, ()-> CollsUtilsFH.containsBoth(coll3,coll4)); //T3
    }

    @Test
    void oneCollElement() {
        Collection<String> coll3 = List.of("a");
        Collection<String> coll4 = Arrays.asList("f", "b", "c");
        assertFalse(CollsUtilsFH.containsBoth(coll3, coll4)); //T5
    }

    //Coll1 = N elements   Coll2 = 1 element
    @Test
    void twoCollWithNullOrOneCollWithNull() {
        Collection<Integer> coll1 = Arrays.asList(1, 2, null);
        Collection<Integer> coll2 = Arrays.asList(3, 4, 5);
        assertFalse(CollsUtilsFH.containsBoth(coll1, coll2)); //T6

        Collection<Integer> coll3 = Arrays.asList(1, 2, null);
        Collection<Integer> coll4 = Arrays.asList(3, null, 4);
        assertTrue(CollsUtilsFH.containsBoth(coll3, coll4)); //T7
    }

    //Coll1 = N elements  Coll2 = N elements
    @Test
    void duplicatesAndRepetitions(){
        Collection<Integer> coll1 = Arrays.asList(1, 2, 2, 4);
        Collection<Integer> coll2 = Arrays.asList(3, 6, 2, 6, 2);
        assertTrue(CollsUtilsFH.containsBoth(coll1,coll2));  //T8

        Collection<String> coll3 = Arrays.asList("a", "b", "b", "c");
        Collection<String> coll4 = Arrays.asList("b", "f", "z");
        assertTrue(CollsUtilsFH.containsBoth(coll3,coll4)); //T9


        Collection<Integer> coll5 = Arrays.asList(1, 2, 2, 4);
        Collection<Integer> coll6 = Arrays.asList(3, 6, 2, 2, 6, 2, 2, 5, 8, 2, 2, 78, 2, 2);
        assertTrue(CollsUtilsFH.containsBoth(coll5,coll6)); //T10

        Collection<String> coll7 = Arrays.asList("a", "b", "b", "c", "v", "b", "b", "b");
        Collection<String> coll8 = Arrays.asList("b", "f", "z");
        assertTrue(CollsUtilsFH.containsBoth(coll7,coll8)); //T11

        Collection<Double> coll9 = Arrays.asList(0.2, 0.6, 0.8, 0.10);
        Collection<Double> coll10 = Arrays.asList(0.6, 0.10, 0.2, 0.8);
        assertTrue(CollsUtilsFH.containsBoth(coll9,coll10)); //T12
    }

    @Test
    void boundary(){
        Collection<Double> coll1 = Arrays.asList(0.42, 0.01, 0.10);
        Collection<Double> coll2 = Arrays.asList(0.66, 0.122, 1.0);
        assertFalse(CollsUtilsFH.containsBoth(coll1,coll2));  //T14

        Collection<String> coll3 = List.of("a");
        Collection<String> coll4 = Arrays.asList("a", "b", "c");
        assertTrue(CollsUtilsFH.containsBoth(coll3, coll4)); //T13
    }

}
