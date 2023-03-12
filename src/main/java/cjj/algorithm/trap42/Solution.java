package cjj.algorithm.trap42;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
       int index = 0;
       Stack<Integer> stack = new Stack<>();
       int sum = 0;
       while (index < height.length) {
           while (!stack.isEmpty() && height[index] > height[stack.peek()]) {
               int hIndex = stack.pop();
               if (stack.isEmpty()) {
                   break;
               }
               int min = Math.min(height[stack.peek()],height[index]);
               int width = index -  stack.peek() - 1;
               sum += (min - height[hIndex]) * width;
           }
           stack.push(index);
           index++;
       }
       return sum;
    }
}
