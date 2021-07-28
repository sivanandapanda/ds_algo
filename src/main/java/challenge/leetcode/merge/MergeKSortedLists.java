package challenge.leetcode.merge;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * leetcode 23
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        if(lists.length == 1) {
            return lists[0];
        }

        if(lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }

        int median = lists.length/2;

        ListNode[] left = new ListNode[median];
        for (int i = 0; i < median; i++) {
            left[i] = lists[i];
        }

        ListNode leftMerged = mergeKLists(left);

        ListNode[] right = new ListNode[lists.length - median];
        for (int i = median; i < lists.length; i++) {
            right[i-median] = lists[i];
        }

        ListNode rightMerged = mergeKLists(right);

        return mergeTwoLists(leftMerged, rightMerged);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        } else if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }

        ListNode mergedNode = new ListNode();

        ListNode currentL1Node;
        ListNode currentL2Node;

        if(l1.val < l2.val) {
            mergedNode.val = l1.val;
            currentL1Node = l1.next;
            currentL2Node = l2;
        } else {
            mergedNode.val = l2.val;
            currentL2Node = l2.next;
            currentL1Node = l1;
        }

        ListNode currentNode = mergedNode;

        while (!(currentL1Node == null && currentL2Node == null)) {

            if(currentL1Node == null) {
                currentNode.next=currentL2Node;
                currentL2Node = currentL2Node.next;
                currentNode = currentNode.next;
                continue;
            }

            if(currentL2Node == null) {
                currentNode.next=currentL1Node;
                currentL1Node = currentL1Node.next;
                currentNode = currentNode.next;
                continue;
            }

            if(currentL1Node.val < currentL2Node.val) {
                currentNode.next=currentL1Node;
                currentL1Node = currentL1Node.next;
                currentNode = currentNode.next;
            } else {
                currentNode.next=currentL2Node;
                currentL2Node = currentL2Node.next;
                currentNode = currentNode.next;
            }
        }

        return mergedNode;
    }
}

