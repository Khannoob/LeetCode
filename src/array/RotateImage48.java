package array;

public class RotateImage48 {
    public void rotate(int[][] matrix) {
        //1. 按159对角线翻转
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //2. 每一行reverse
        for(int[] row : matrix){
            reverse(row);
        }
    }

    void reverse(int[] row){
        int i = 0, j = row.length-1;
        while(i < j){
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            j--;
            i++;
        }
    }
}
