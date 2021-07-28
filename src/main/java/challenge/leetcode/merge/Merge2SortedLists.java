package challenge.leetcode.merge;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * leet code 21
 */
public class Merge2SortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

