package cjj.algorithm.noderingstart;

import cjj.algorithm.ListNode;

public class Solution {
    public static void main(String[] args) {

    }

    // todo 环入口
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null &&  fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                break;
            }
        }

        if(fast== null || fast.next == null){
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
