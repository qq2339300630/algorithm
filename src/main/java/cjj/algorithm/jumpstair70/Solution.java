package cjj.algorithm.jumpstair70;

public class Solution {
    public static void main(String[] args) {
       System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return  2;
        }
        int sum = 0;
        int s1 = 1;
        int s2 = 2;
        for (int i = 3; i <= n; i++) {
            sum = s1 + s2;
            s1 = s2;
            s2 = sum;
        }
        return sum;
    }
}
