package leetcode;

import java.math.BigInteger;

public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var check = l1;
        var str1 = ""+check.val;
        while (check.next!=null) {
            var next = check.next;
            str1 += String.valueOf(next.val);
            check=next;
        }
        check = l2;
        var str2 = ""+check.val;
        while (check.next!=null) {
            var next = check.next;
            str2 += next.val;
            check=next;
        }
        var originStr1= reverse(str1);
        var originStr2= reverse(str2);
        var bigInt1 = new BigInteger(originStr1);
        var bigInt2 = new BigInteger(originStr2);
        var sumBigInt =  bigInt1.add(bigInt2);
        var reversedResult = sumBigInt.toString();
        var resultString = reverse(reversedResult);
        var result = new ListNode(resultString.charAt(0)-'0');
        var current = result;
        for (int i=1; i<resultString.length(); i++) {
            var newListNode = new ListNode(resultString.charAt(i)-'0');
            current.next = newListNode;
            current = newListNode;
        }
        print(resultString);
        return result;
    }

    private void print(String result) {
        System.out.print("[");
        for (int i=0; i<result.length(); i++) {
            System.out.print(result.charAt(i));
            if(i<result.length()-1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    private String reverse(String str1) {
        var result = "";
        for (int i=str1.length()-1; i>=0; i--) {
            result+=String.valueOf(str1.charAt(i));
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
