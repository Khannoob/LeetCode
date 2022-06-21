package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        String[] temp = sc.nextLine().split(" ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
            sum += nums[i];
        }
        memo = new int[n][n];
        for (int[] v : memo) {
            Arrays.fill(v, -1);
        }
        int res = dp(nums, 0, n - 1, sum);
        System.out.println(res);
    }

    static int[][] memo;

    static int dp(int[] nums, int i, int j, int sum) {
        //二维数组 memo
        //base case
        if (i == j) {
            return sum / nums[i];
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        //状态转移
        int head = sum / nums[i];
        int tail = sum / nums[j];
        memo[i][j]= Math.max(dp(nums, i + 1, j, sum - nums[i]) + head, dp(nums, i, j - 1, sum - nums[j]) + tail);
        return memo[i][j];
    }
}
