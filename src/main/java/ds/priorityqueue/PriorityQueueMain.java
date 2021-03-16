package ds.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueMain {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        pqTest(minHeap);
        System.out.println("===========");
        pqTest(maxHeap);
    }

    private static void pqTest(PriorityQueue<Integer> pq) {
        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.peek());

        System.out.println(pq.poll());
        System.out.println(pq.peek());

        System.out.println(pq.remove(54));
        System.out.println(pq.peek());

        pq.add(-1);
        System.out.println(pq.peek());

        System.out.println(Arrays.toString(pq.toArray()));
    }
}
