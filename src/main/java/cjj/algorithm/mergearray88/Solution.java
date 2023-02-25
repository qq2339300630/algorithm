package cjj.algorithm.mergearray88;

public class Solution {
    public static void main(String[] args) {
        merge(new int[]{4,5,6,0,0,0},3,new int[]{1,2,3},3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length;
        while (n > 0) {
            if (m > 0 && nums1[m-1] > nums2[n-1]) {
                nums1[--i] = nums1[--m];
            } else {
                nums1[--i] = nums2[--n];
            }
        }
    }
}
