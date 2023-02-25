package cjj.algorithm.rotatearray189;

public class Solution {

    public static void main(String[] args) {
       int[] array =  new int[]{1,2,3,4,5};
       rotate(array,1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k%nums.length;
        }
        rotate(nums,0,nums.length -1);
        rotate(nums,0,k - 1);
        rotate(nums,k,nums.length-1);
    }

    public static void rotate(int[] nums,int start,int end) {
        while (start < end) {
            int tem = nums[start];
            nums[start] = nums[end];
            nums[end] = tem;
            start++;
            end--;
        }
    }
}
