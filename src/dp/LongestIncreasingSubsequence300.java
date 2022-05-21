package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);//递增子序列至少长度为1
        //循环求出每一个dp[i]对应的值
        //dp[i]是以nums[i]结尾的连续递增序列,先找出所有小于nums[i]对应的dp[x],然后求最大值
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int res = 0;
        for(int i = 0; i < dp.length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
