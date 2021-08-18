package challenge.leetcode.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionListTest {

    @Test
    void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);

        var result = new PartitionList().partition(l1, 3);

        System.out.println(result.val);
        while(result.next != null) {
            System.out.println(result.next.val);
            result = result.next;
        }
    }

    @Test
    void test_2() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(1);

        var result = new PartitionList().partition(l1, 2);

        System.out.println(result.val);
        while(result.next != null) {
            System.out.println(result.next.val);
            result = result.next;
        }
    }
}