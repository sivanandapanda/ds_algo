package challenge.leetcode.list;

/*
 * https://leetcode.com/problems/partition-list/submissions/
 * leetcode 86
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode before = null;
        ListNode beforeParentPointer = null;
        ListNode after = null;
        ListNode afterParentPointer = null;

        ListNode next = head;

        while (next != null) {

            if(next.val < x) {
                if(before == null) {
                    before = new ListNode(next.val);
                    beforeParentPointer = before;
                } else {
                    beforeParentPointer.next = new ListNode(next.val);
                    beforeParentPointer = beforeParentPointer.next;
                }
            } else {
                if(after == null) {
                    after = new ListNode(next.val);
                    afterParentPointer = after;
                } else {
                    afterParentPointer.next = new ListNode(next.val);
                    afterParentPointer = afterParentPointer.next;
                }
            }

            next = next.next;
        }

        ListNode finalList;
        if(beforeParentPointer != null) {
            beforeParentPointer.next = after;
            finalList = before;
        } else {
            finalList = after;
        }

        return finalList;
    }

}
