package dp;

import java.util.Arrays;

public class EditDistance72 {
//自上向下
    int[][] memo;

    public int minDistance2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        memo = new int[m][n];
        for(int[] v : memo) Arrays.fill(v, 1000);
        return dp(word1, word2, m-1, n-1);
    }

    int dp(String word1, String word2, int i, int j){
        //base case 如果一条串遍历完,剩下的直接加上或删除,加一是0位
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(memo[i][j]!=1000) return memo[i][j];
        //skip 相同不用操作+0
        if(word1.charAt(i) == word2.charAt(j)) return dp(word1, word2, i-1, j-1);
        memo[i][j] = min(dp(word1, word2, i, j-1)+1, //增加,i不动, j后移
                dp(word1, word2, i-1, j)+1,//删除,i后移, j不动
                dp(word1, word2, i-1, j-1)+1 //替换
        );
        return memo[i][j];
    }

//自下向上
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] memo = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){//第一个串自己的长度,第二串为0 -> 删除
            memo[i][0] = i;
        }

        for(int j = 1; j <= n; j++){//第二个串自己的长度,第一串为0 -> 增加
            memo[0][j] = j;
        }

        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) memo[i][j] = memo[i-1][j-1];//skip
                else{
                    memo[i][j] = min(memo[i-1][j]+1, //delete
                            memo[i][j-1]+1, //insert
                            memo[i-1][j-1]+1);//replace
                }
            }
        }
        return memo[m][n];
    }

    int min(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }
}
