package ds.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//todo fix test case failures
public class DynamicArrayTest {

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>(16);
        list.add(0, 1);
        list.add(1, 1);
        var integer = list.get(1);
        System.out.println(integer);
    }

    @Test
    public void create_array() {
        DynamicArray<String> arr = new DynamicArray<>();
        arr.add("Hello");
        Assertions.assertEquals("[Hello, null]", arr.toString());
        Assertions.assertEquals(1, arr.size());
    }

    @Test
    public void set_out_of_bound_index() {
        DynamicArray<String> arr = new DynamicArray<>();
        arr.set(2, "Hello");
    }

    @Test
    public void create_dynamic_array() {
        DynamicArray<String> arr = new DynamicArray<>();
        arr.add("Hello");
        Assertions.assertEquals("[Hello, null]", arr.toString());
        Assertions.assertEquals(1, arr.size());
        arr.add("world");
        Assertions.assertEquals("[Hello, world]", arr.toString());
        Assertions.assertEquals(2, arr.size());
        arr.add("!");
        Assertions.assertEquals("[Hello, world, !, null]", arr.toString());
        Assertions.assertEquals(3, arr.size());
    }

    @Test
    public void clear() {
        DynamicArray<String> arr = new DynamicArray<>();
        arr.add("Hello");
        arr.add("world");
        arr.clear();
        Assertions.assertEquals("[null, null]", arr.toString());
        Assertions.assertEquals(0, arr.size());
    }

    @Test
    public void iterate() {
        DynamicArray<Integer> arr = new DynamicArray<>(5);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(4);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    @Test
    public void remove() {
        DynamicArray<Integer> arr = new DynamicArray<>(5);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(4);

        arr.remove(3);
        Assertions.assertEquals("[2, 1, 5, 4, null]", arr.toString());
        Assertions.assertEquals(4, arr.size());
    }

    @Test
    public void remove_from_dynamic() {
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(4);

        Assertions.assertTrue(arr.remove(3));
        Assertions.assertEquals("[2, 1, 5, 4, null, null, null, null]", arr.toString());
        Assertions.assertEquals(4, arr.size());
    }

    @Test
    public void remove_at() {
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(4);

        Assertions.assertTrue(arr.removeAt(3));
        Assertions.assertEquals("[2, 1, 3, 4, null, null, null, null]", arr.toString());
        Assertions.assertEquals(4, arr.size());
        Assertions.assertFalse(arr.isEmpty());
        Assertions.assertFalse(arr.contains(10));
        Assertions.assertTrue(arr.contains(5));
        Assertions.assertEquals(2, arr.get(0), 0);
    }

}