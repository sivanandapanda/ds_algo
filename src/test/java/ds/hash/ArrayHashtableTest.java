package ds.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHashtableTest {

    @Test
    public void test() {
        ArrayHashtable<String, String> hashtable = new ArrayHashtable<>();

        hashtable.put("John", "Smith");
        hashtable.put("Marry", "Smith");
        hashtable.put("Albert", "Martin");
        System.out.println(hashtable.get("Albert"));
        System.out.println(hashtable.get("John"));
        hashtable.put("John", "Johney");
        hashtable.printHashtable();
        System.out.println(hashtable.remove("John"));
        hashtable.put("John", "Johney");
        System.out.println(hashtable.get("John"));
        hashtable.printHashtable();
    }

}