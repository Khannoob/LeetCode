package dfs;

public class NumberOfIslands200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    void dfs(char[][] grid, int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length) return;
        if(grid[i][j]=='0') return;
        grid[i][j] = '0';
        for(int[] d: dirs){
            int i_next = i + d[0];
            int j_next = j + d[1];
            dfs(grid,i_next,j_next);
        }
    }
}
