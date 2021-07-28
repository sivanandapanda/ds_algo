package challenge.leetcode.merge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Merge2SortedListsTest {

    @Test
    void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);
        l3.next.next.next = new ListNode(5);

        var mergedList = new MergeKSortedLists().mergeKLists(new ListNode[]{l1, l2, l3});

        System.out.println(mergedList.val);
        while(mergedList.next != null) {
            System.out.println(mergedList.next.val);
            mergedList = mergedList.next;
        }
    }

}