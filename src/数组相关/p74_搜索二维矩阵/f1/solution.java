package 数组相关.p74_搜索二维矩阵.f1;

public class solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix ==null){
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >=0){
            if (matrix[row][0]>target){
                return false;
            }
            if (matrix[row][col]<target){
                row++;
            } else if (matrix[row][col]>target){
                col--;
            }else {
                return true;
            }
        }
            return false;
    }
}
