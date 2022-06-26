package array;

public class SpiralMatrixII59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int upper_bound = 0, lower_bound = n-1;
        int left_bound = 0, right_bound = n-1;
        while(num <= n * n){
            //上边界 从左到右
            if(upper_bound <= lower_bound){
                for(int i = left_bound; i <= right_bound; i++){
                    matrix[upper_bound][i] = num++;
                }
                upper_bound++;
            }

            //右边界,从上到下
            if(left_bound<=right_bound){
                for(int i = upper_bound; i <= lower_bound; i++){
                    matrix[i][right_bound] = num++;
                }
                right_bound--;
            }

            //下边界,从右到左
            if(upper_bound <= lower_bound){
                for(int i = right_bound; i >= left_bound; i--){
                    matrix[lower_bound][i] = num++;
                }
                lower_bound--;
            }

            //左边界,从下到上
            if(left_bound<=right_bound){
                for(int i = lower_bound; i >= upper_bound; i--){
                    matrix[i][left_bound] = num++;
                }
                left_bound++;
            }
        }
        return matrix;
    }
}
