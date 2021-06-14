package ds.list;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTimeComplexity {

    public static void main(String[] args) {
        insertAtFirstIndexComparison();
        insertAtLastIndexComparison();
    }

    private static void insertAtFirstIndexComparison() {
        List<Integer> array = new ArrayList<>();
        var startTime = LocalDateTime.now();

        for (int i = 0; i < 500000; i++) {
            array.add(0, i);
        }
        System.out.println("Time taken for Arraylist to insert at first index: " + Duration.between(startTime, LocalDateTime.now()));

        startTime = LocalDateTime.now();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 500000; i++) {
            list.addFirst(i);
        }
        System.out.println("Time taken for LinkedList to insert at first index: " + Duration.between(startTime, LocalDateTime.now()));
    }

    private static void insertAtLastIndexComparison() {
        List<Integer> array = new ArrayList<>();
        var startTime = LocalDateTime.now();

        for (int i = 0; i < 500000; i++) {
            array.add(i);
        }
        System.out.println("Time taken for Arraylist to insert at last index: " + Duration.between(startTime, LocalDateTime.now()));

        startTime = LocalDateTime.now();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 500000; i++) {
            list.addLast(i);
        }
        System.out.println("Time taken for LinkedList to insert at last index: " + Duration.between(startTime, LocalDateTime.now()));
    }
}
