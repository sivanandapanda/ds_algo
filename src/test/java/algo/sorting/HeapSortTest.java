package algo.sorting;

import ds.heap.Heap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    void should_sort_heap() {
        Heap heap = new Heap(15);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        HeapSort heapSort = new HeapSort(heap);

        heapSort.sort();

        System.out.println(heapSort.getHeap().printHeap());
        assertEquals("40, 52, 55, 60, 67, 68, 75, 80, ", heapSort.getHeap().printHeap());
    }

}