package dfs;

public class NumberOfEnclaves1020 {
    public static void main(String[] args) {
        NumberOfEnclaves1020 ne = new NumberOfEnclaves1020();
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        ne.numEnclaves(grid);
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            grid[i][0] = '0';
            grid[i][n-1] = '0';
        }
        for(int j = 0; j<n;j++){
            grid[0][j] = '0';
            grid[m-1][j] = '0';
        }
        for(int i=0; i < m; i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    void dfs(int[][] grid, int i , int j){
        int m = grid.length, n = grid[0].length;
        if(i<0||j<0||i>=m||j>=n) return;
        if(grid[i][j]=='0') return;
        grid[i][j] = '0';
        for(int[] d : dirs){
            int i_next = i+d[0];
            int j_next = j+d[1];
            dfs(grid,i_next,j_next);
        }
    }
}
