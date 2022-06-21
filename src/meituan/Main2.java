package meituan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    static int[] res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        String[] temp = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        //获取自己的因数
        res = new int[n];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = helper(i + 1);
            HashSet<Integer> colors = new HashSet<>();

            for (Integer v : list) {
                colors.add(nums[v]);
            }
            res[i] = colors.size();
            System.out.println(res[i]);
        }
    }


    static ArrayList<Integer> helper(int i) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) list.add(j - 1);
        }
        return list;
    }
}
