package cjj.algorithm.reverseList206;

import cjj.algorithm.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


    public static ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode next = null;
        ListNode pre = null;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }


    public static ListNode swapPairs11(ListNode head) {
        ListNode h1 = head;
        if (head == null || head.next == null) {
            return head;
        }

        ListNode h2 = h1.next;
        ListNode h3 = h2.next;

        //特殊处理头节点
        h2.next = h1;
        h1.next = h3;
        head = h2;

        // 移动位置  h1 为h2前驱，h3为h2的前驱
        h2 = h1.next;
        if (h2 != null) {
            h3 = h2.next;
        } else  {
            return head;
        }

        //交换h2,h3
        while (h3 != null) {
            //删除h2
            h1.next = h3;
            //将h2插入h3后面
            h2.next = h3.next;
            h3.next = h2;

            h1 = h1.next;
            h1 = h1.next;
            h2 = h1.next;
            if (h2 != null) {
                h3 = h2.next;
            } else {
                break;
            }
        }
        return head;
    }

    // todo 递归版交换两个节点
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }


    public static ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0,head);
        ListNode a;
        ListNode b;
        ListNode tem = head;
        while (tem!=null && tem.next != null) {
            a = tem.next;
            b = tem.next.next;
            tem = b;
            a.next = b.next;
            b.next = a;
        }
        return pre.next;
    }

}
