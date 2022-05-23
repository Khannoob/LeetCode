package dp;

import java.util.Arrays;

public class MinimumFallingPathSum931 {
    int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        memo = new int[m+1][n+1];
        for(int[] v : memo){
            Arrays.fill(v, -10001);//这里应该是(-10000,10000) 长度最大是100 值最大是100
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++){
            res = Math.min(res, dp(matrix,m,i));
        }
        return res;
    }

    int dp(int[][] matrix, int i, int j){
        //越界处理
        if(i<0 || j<0 ||
                i>=matrix.length ||
                j>=matrix[0].length)
            return 99999;

        //首行处理
        if(i==0) return matrix[i][j];
        if(memo[i][j]!=-101) return memo[i][j];
        //状态转移方程
        memo[i][j] = matrix[i][j] + min(dp(matrix,i-1,j-1),
                dp(matrix,i-1,j),
                dp(matrix,i-1,j+1));
        return memo[i][j];
    }

    int min(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }
}
