package cjj.algorithm.maxSlidingWindow239;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,-1},1);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
         Deque<Integer> deque = new ArrayDeque<>();
         int[] result = new int[nums.length - k + 1];
         int index = 0;
         for (int i = 0; i < nums.length; i++) {
             while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
              deque.pollLast();
             }
             deque.addLast(i);
             while (!deque.isEmpty() && i - nums[deque.peekFirst()] >= k) {
                 deque.pollFirst();
             }
             if (i - k >= -1) {
                 result[index++] = nums[deque.peekFirst()];
             }
         }
         return result;
    }
}
