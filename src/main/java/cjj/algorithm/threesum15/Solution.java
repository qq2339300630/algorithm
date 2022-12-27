package cjj.algorithm.threesum15;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        threeSum(new int[]{0, 0, 0});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int x = i + 1;
            int y = nums.length - 1;
            while (x < y) {
                if (nums[x] + nums[y] + nums[i] > 0) {
                    y--;
                } else if (nums[x] + nums[y] + nums[i] < 0) {
                    x++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[x]);
                    list.add(nums[y]);
                    set.add(list);
                    x++;
                    y--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
