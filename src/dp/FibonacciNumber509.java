package dp;

public class FibonacciNumber509 {
    public int fib(int n) {
        //状态转移方程+字典memo F(n) =  F(n-1) + F(n-2) 自上而下
        int[] memo = new int[n+1];
        return helper(memo,n);
    }
    int helper(int[] memo, int n){
        if(n==0 || n==1) return n;
        if(memo[n] != 0) return memo[n];
        memo[n] = helper(memo,n-1)+helper(memo,n-2);
        return  memo[n];
    }

    //自下而上
    public int fib2(int n) {
        if (n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }
}
