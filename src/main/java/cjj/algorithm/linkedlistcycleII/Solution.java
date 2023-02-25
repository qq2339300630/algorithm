package cjj.algorithm.linkedlistcycleII;

import cjj.algorithm.ListNode;

public class Solution {
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
        boolean hasCycle = false;
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        } else {
            return null;
        }
    }
}
