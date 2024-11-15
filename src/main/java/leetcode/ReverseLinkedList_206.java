package leetcode;

public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }

        var next = head.next;
        var reverseList = reverseList(next);
        next.next=head;
        head.next=null;
        return reverseList;
    }
}
