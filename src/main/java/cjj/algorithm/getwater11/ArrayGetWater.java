package cjj.algorithm.getwater11;

public class ArrayGetWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /// t
    public static int maxArea(int[] height) {
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            sum = Math.max(sum, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }
}
