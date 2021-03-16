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

    @Test
    void should_delete_from_heap() {
        Heap heap = new Heap(15);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        System.out.println(heap.printHeap());

        assertEquals("80, 75, 60, 68, 55, 40, 52, 67, ", heap.printHeap());

        assertEquals(75, heap.delete(1));
        assertEquals("80, 68, 60, 67, 55, 40, 52, ", heap.printHeap());
        System.out.println(heap.printHeap());

        assertEquals(40, heap.delete(5));
        assertEquals("80, 68, 60, 67, 55, 52, ", heap.printHeap());
        System.out.println(heap.printHeap());

        assertEquals(80, heap.delete(0));
        assertEquals("68, 67, 60, 52, 55, ", heap.printHeap());
        System.out.println(heap.printHeap());
    }

    @Test
    void should_peek_from_heap() {
        Heap heap = new Heap(15);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        assertEquals(80, heap.peek());
        assertEquals(75, heap.delete(1));

        assertEquals(80, heap.peek());
        assertEquals(80, heap.delete(0));
        assertEquals(68, heap.peek());
    }
}