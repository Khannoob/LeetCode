package dp;

public class RobHouse {
    public static void main(String[] args) {
        RobHouse rh = new RobHouse();
        int[] nums = {2, 3, 4, 5, 3};
        System.out.println(rh.rob3(nums));
    }

    //1.状态转移方程 f(n) = max(f(n-1) , nums[n]+f(n-2))
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        helper(nums, len - 1, dp);
        return Math.max(dp[len - 1], dp[len - 2]);
    }

    //自上而下
    void helper(int[] nums, int n, int[] dp) {
        if (n < 2) {
            dp[n] = nums[n];
        } else if (dp[n] == 0) {
            helper(nums, n - 1, dp);
            helper(nums, n - 2, dp);
            dp[n] = Math.max(dp[n - 1], dp[n - 2] + nums[n]);
        }
    }

    //自下而上
    public int rob2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        if (nums.length > 1) {
            dp[1] = Math.max(nums[1], nums[0]);
        }

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return Math.max(dp[len - 1], dp[len - 2]);
    }

    public int rob3(int[] nums) {
        if (nums.length == 0)
            return 0;
        int len = nums.length;
        int[] dp = new int[2];
        dp[0] = nums[0];
        if (nums.length > 1) {
            dp[1] = Math.max(nums[1], nums[0]);
        }
        for (int i = 2; i < len; i++) {
            dp[i % 2] = Math.max(dp[(i - 1)%2], dp[(i - 2)%2] + nums[i]);
        }
        return Math.max(dp[0], dp[1]);
    }
}
