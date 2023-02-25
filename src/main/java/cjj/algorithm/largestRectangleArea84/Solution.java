package cjj.algorithm.largestRectangleArea84;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();
        int maxArea = 0;
        for (int right = 0; right < heights.length; right++) {
            while (!deque.isEmpty() && heights[right] < heights[deque.peek()]) {
                int index = deque.pop();
                int left = deque.isEmpty() ? -1 : deque.peek();
                maxArea = Math.max(maxArea, heights[index] * (right - left - 1));
            }
            deque.push(right);
        }
        while (!deque.isEmpty()) {
            int index = deque.pop();
            int left = deque.isEmpty() ? -1 : deque.peek();
            maxArea = Math.max(maxArea, heights[index] * (index - left - 1));
        }
        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            //当前栈顶不为空，后有一个元素小于等于当前元素进行弹出并计算面积
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                Integer popIndex = stack.pop();
                int leftThanIndex = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(heights[popIndex] * (i - leftThanIndex - 1), maxArea);
            }
            //弹出完成放入这个元素，继续进行单调栈的循环
            stack.push(i);
        }
        //把栈中剩余的元素再来进行计算
        while (!stack.isEmpty()) {
            Integer popIndex = stack.pop();
            int leftThanIndex = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(heights[popIndex] * (heights.length - leftThanIndex - 1), maxArea);
        }
        return maxArea;
    }


}
