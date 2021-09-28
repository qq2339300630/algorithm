package cjj.algorithm.reverseList206;

import cjj.algorithm.ListNode;

public class ReverseList {
    private static ListNode next = null;

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        reverseBetweenWhile(head, 2, 4);
        //reverseNWhile(head,3);
    }

    // todo 递归实现整个链表反转
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    // todo 递归实现部分链表反转
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // todo 递归实现 前n个节点反转
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


    // todo 便利实现链表反转
    public static ListNode reverseListWhile(ListNode head) {
        ListNode p = head;
        ListNode pre = null;
        ListNode next = null;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }


    // todo 便利实现前n个节点反转
    public static ListNode reverseNWhile(ListNode head, int n) {
        ListNode p = head;
        ListNode pre = null;
        ListNode next = null;
        while (p != null && n > 0) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
            n--;
        }
        head.next = next;
        return pre;
    }


    // todo 便利实现部分链表反转
    public static ListNode reverseBetweenWhile(ListNode head, int left, int right) {
        ListNode p = head;
        if (left == 1) {
          head = reverseNWhile(head,right);
        } else {
            for (int i = 0; i < left - 2; i++) {
                p = p.next;
            }
            p.next = reverseNWhile(p.next, right - left + 1);
        }
        return head;
    }

}


