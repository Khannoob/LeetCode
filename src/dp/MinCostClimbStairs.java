package dp;

public class MinCostClimbStairs {

    public static void main(String[] args) {
        MinCostClimbStairs mc = new MinCostClimbStairs();
        int[] arr = {1, 100, 1, 1, 100, 1};
        System.out.println(mc.minCostClimbingStairs(arr));
    }

    //1.状态转移方程f(n) = min(f(n-1), f(n-2))+cost[n]
    int dfs(int[] cost, int n) {
        if (n < 2) {
            return cost[n];
        }
        return Math.min(dfs(cost, n - 1), dfs(cost, n - 2)) + cost[n];
    }

    void dpDfs(int[] cost, int n, int[] dp) {
        if (n < 2) {
            dp[n] = cost[n];
        } else if (dp[n] == 0) {
            dpDfs(cost, n - 1, dp);
            dpDfs(cost, n - 2, dp);
            dp[n] = Math.min(dp[n - 1], dp[n - 2]) + cost[n];
        }
    }

    //递归 自上而下
    public int minCostClimbingStairs(int[] cost) {
        //2.使用缓存数组减少重复计算,初始化dp[]所有值为0
        //把每次计算结果都保存在dp[]数组中,如果为0才计算
        int n = cost.length - 1;
        int[] dp = new int[n + 1];
        dpDfs(cost, n, dp);
        return Math.min(dp[n], dp[n - 1]);
    }

    //迭代 自下而上 空间O(n)
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    //迭代 自下而上 空间O(1)
    public int minCostClimbingStairs3(int[] cost) {
        int[] dp = {cost[0], cost[1]};
        int n = cost.length;
        for (int i = 2; i < n; i++) {
            dp[i % 2] = Math.min(dp[0], dp[1]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }
}
