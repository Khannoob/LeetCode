package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        int m = matrix.length, n = matrix[0].length;
        int upper_bound = 0, lower_bound = m-1;
        int left_bound = 0, right_bound = n-1;
        while(res.size() < m * n){
            //上边界 从左到右
            if(upper_bound <= lower_bound){
                for(int i = left_bound; i <= right_bound; i++){
                    res.add(matrix[upper_bound][i]);
                }
                upper_bound++;
            }

            //右边界,从上到下
            if(left_bound<=right_bound){
                for(int i = upper_bound; i <= lower_bound; i++){
                    res.add(matrix[i][right_bound]);
                }
                right_bound--;
            }

            //下边界,从右到左
            if(upper_bound <= lower_bound){
                for(int i = right_bound; i >= left_bound; i--){
                    res.add(matrix[lower_bound][i]);
                }
                lower_bound--;
            }

            //左边界,从下到上
            if(left_bound<=right_bound){
                for(int i = lower_bound; i >= upper_bound; i--){
                    res.add(matrix[i][left_bound]);
                }
                left_bound++;
            }
        }
        return res;
    }
}
