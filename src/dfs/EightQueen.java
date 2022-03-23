package dfs;

import java.util.HashMap;

public class EightQueen {
    HashMap map = new HashMap();
    public static int getEightQueenSols(int n){
        int[][] chess = new int[n][n];
        int cnt = 0;
        for (int i = 0; i < chess[0].length; i++) {
            int x = i;
            for (int j = 0; j < chess.length; j++) {
                int y = j;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        System.out.println(getEightQueenSols(8));
    }
    private static int dfs(int x){
        return 0;
    }
}
