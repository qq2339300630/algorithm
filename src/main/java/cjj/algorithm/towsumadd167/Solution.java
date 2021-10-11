package cjj.algorithm.towsumadd167;

public class Solution {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
      int[] nums = new int[2];
      int left = 0;
      int right = numbers.length - 1;
      while (left < right && numbers[left] + numbers[right] != target) {
          int sum = numbers[left] + numbers[right];
          if (sum < target) {
              left++;
          } else {
              right--;
          }
      }
      nums[0] = left + 1;
      nums[1] = right + 1;
      return  nums;
    }
}
