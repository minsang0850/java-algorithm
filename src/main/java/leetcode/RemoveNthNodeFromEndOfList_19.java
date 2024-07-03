package leetcode;

public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode front = start, back = start;
        start.next = head;

        for (int i = 1; i <= n + 1; i++) {
            back = back.next;
        }

        while (back != null) {
            front = front.next;
            back = back.next;
        }

        front.next = front.next.next;

        return start.next;
    }
}


