package challenge.leetcode.list;

import org.junit.jupiter.api.Test;

class MergeKSortedListsTest {
    @Test
    void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        var mergedList = new Merge2SortedLists().mergeTwoLists(l1, l2);

        System.out.println(mergedList.val);
        while(mergedList.next != null) {
            System.out.println(mergedList.next.val);
            mergedList = mergedList.next;
        }
    }
}