package cjj.algorithm.reverseList206;

public class Solution {
    private static ListNode next = null;

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        reverseBetween(head,2,4);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }



    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1 || head.next == null) {
            next = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        for (int i = n; i > 0; i--) {
            System.out.println(" ");
        }
        System.out.println("next:" + next.val + ", n:" + n);
        System.out.println("head:" + head.val + ", n:" + n);
        head.next.next = head;
        head.next = next;
        return last;
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
