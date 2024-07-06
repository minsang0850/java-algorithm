package leetcode;

public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        var first = head;
        if(head==null || head.next==null) {
            return head;
        }
        var second = head.next;
        var answer = second;
        ListNode prev = null;
        while(true) {
            if(prev!=null) {
                prev.next=second;
            }
            first.next= second.next;
            second.next=first;
            prev=first;
            first = first.next;
            if(first==null || first.next==null) {
                break;
            }
            second = first.next;
        }
        return answer;
    }
}
