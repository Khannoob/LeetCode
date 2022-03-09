package everyday;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @author: Khan
 * @create: 2022-03-09 16:43
 */
public class platesBetweenCandles2055 {
    public static void main(String[] args) {
        platesBetweenCandles2055 pb = new platesBetweenCandles2055();
        int[][] queries = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        int[] ints = pb.platesBetweenCandles("***|**|*****|**||**|*", queries);
        System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));
    }

    //前缀和 预处理
    public int[] platesBetweenCandles(String s, int[][] queries) {
        //1.前缀和数组
        int n = s.length();
        char[] sChar = s.toCharArray();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (sChar[i] == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        //2.左边蜡烛位置数组
        int[] left = new int[n];
        int l = -1;
        for (int i = 0; i < n; i++) {
            if (sChar[i] == '|') {
                l = i;
            }
            left[i] = l;
        }
        //3.右边蜡烛位置数组
        int r = -1;
        int[] right = new int[n];
        for (int i = n - 1; i > -1; i--) {
            if (sChar[i] == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            ans[i] = x < 0 || y < 0 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return ans;
    }
}
