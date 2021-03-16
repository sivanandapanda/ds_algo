package algo.sorting;

import ds.heap.Heap;

public class HeapSort {

    private final Heap heap;

    public HeapSort(Heap heap) {
        this.heap = heap;
    }

    public void sort() {
        heap.sort();
    }

    public Heap getHeap() {
        return heap;
    }
}
