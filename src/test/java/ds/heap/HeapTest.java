package ds.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    @Test
    void should_insert_to_heap() {
        Heap heap = new Heap(15);

        heap.insert(2);
        heap.insert(5);
        heap.insert(25);
        heap.insert(15);
    }

}