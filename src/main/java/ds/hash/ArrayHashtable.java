package ds.hash;

import java.util.Arrays;

public class ArrayHashtable<K, V> {

    private final V[] hashtable;

    public ArrayHashtable() {
        //noinspection unchecked
        this.hashtable = (V[]) new Object[10];
    }

    private int hashKey(K key) {
        return key.hashCode() % hashtable.length;
    }

    public void put(K key, V value) {
        int hashedKey = hashKey(key);

        if(hashtable[hashedKey] != null) {
            System.out.println("sorry the position "+ hashedKey+" is not empty, can't insert " + key + " with value " + value);
        } else {
            hashtable[hashedKey] = value;
        }
    }

    public V get(K key) {
        return hashtable[hashKey(key)];
    }

    public boolean remove(K key) {
        int hashedKey = hashKey(key);

        if(hashtable[hashedKey] != null) {
            hashtable[hashedKey] = null;
            return true;
        } else {
            return false;
        }
    }

    public void printHashtable() {
        System.out.println(Arrays.toString(hashtable));
    }
}
