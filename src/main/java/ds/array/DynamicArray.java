package ds.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;
    private int len = 0;
    private int capacity;

    public DynamicArray() {
        this(2);
    }

    public DynamicArray(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity " + capacity);
        }
        this.capacity = capacity;
        arr = createArray(capacity);
    }

    private T[] createArray(int capacity) {
        return (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if(index >= capacity || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return arr[index];
    }

    public void set(int index, T elem) {
        if(index >= capacity || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        arr[index] = elem;
    }

    public void add(T elem) {
        if(len +1 >= capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity = capacity * 2;
            }
            T[] newArr = createArray(capacity);
            IntStream.range(0, arr.length).forEach(i -> newArr[i] = arr[i]);
            arr = newArr;
        }
        arr[len++] = elem;
    }

    public boolean remove(T elem) {
        int index = indexOf(elem);
        return removeAt(index);
    }

    public boolean removeAt(int index) {
        if(index > -1 && len > 0) {
            IntStream.range(index, len-1).forEach(i -> arr[i] = arr[i+1]);
            arr[len-1] = null;
            len--;
            return true;
        } else {
            return false;
        }
    }

    public int indexOf(T elem) {
        for (int i = 0; i < arr.length; i++) {
            if (elem == null) {
                if (arr[i] == null) return i;
            } else if(arr[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T elem) {
        return indexOf(elem) != -1;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                return arr[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
