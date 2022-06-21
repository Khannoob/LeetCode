package meituan;

import java.util.Scanner;

public class FlipArray12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]), m = Integer.parseInt(line1[1]);
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(s[j]);
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = nums[j][i];
                if (j==n-1) System.out.println(res[i][j]);
                else  System.out.print(res[i][j]+" ");
            }
        }
    }
}
