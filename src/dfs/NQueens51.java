package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens51 {
    List<List<String>> res = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(board, 0);
        return res;
    }
    void backtrack(char[][] board, int row){
        //结束条件
        if(row==board.length){
            res.add(char2List(board));
        }
        //循环
        int n = board.length;
        for(int col=0; col<n;col++){
            //剪枝
            if(!isValid(board,row,col)){
                continue;
            }
            //做选择
            board[row][col] = 'Q';
            backtrack(board, row+1);
            //撤销选择
            board[row][col] = '.';
        }
    }

    boolean isValid(char[][] board, int row, int col){
        int n = board.length;
        //同列冲突(上方)
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q') return false;
        }
        //右上方冲突
        for(int i= col+1, j = row -1;i<n && j>=0;i++,j--){
            if(board[j][i]=='Q') return false;
        }
        //左上方冲突
        for(int i = col-1, j = row -1; i>=0 && j>=0;i--,j--){
            if(board[j][i]=='Q') return false;
        }
        return  true;
    }

    ArrayList<String> char2List(char[][] board){
        ArrayList<String> arr = new ArrayList(board.length);
        for(char[] c: board){
            String s = String.valueOf(c);
            arr.add(s);
        }
        return arr;
    }
}
