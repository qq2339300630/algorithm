package cjj.algorithm.palindromelink027;

import cjj.algorithm.ListNode;

public class PalindromeLinked {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1, null)))));
        System.out.println(isPalindrome2(head));
    }

    static ListNode p = null;


    //todo 递归实现后续便利 检查回文串
    public static boolean isPalindrome(ListNode head) {
        p = head;
        return palindrome(head);
    }

    public static boolean palindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean src = palindrome(head.next);
        boolean result = p.val == head.val && src;
        p = p.next;
        return result;
    }

    // todo 反转部分节点实现链表反转
    public static boolean isPalindrome2(ListNode head) {
        ListNode middle = findMiddleNode(head);
        ListNode reverseNode = reverseList(middle);
        ListNode q = head;
        ListNode p = reverseNode;
        while (p != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        // todo 接回来反转的链表 不破坏head
        q.next = reverseList(reverseNode);
        return true;
    }

    // todo 反转链表
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // todo 寻找中点
    public static ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null)
            slow = slow.next;
        return slow;
    }


}
