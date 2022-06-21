package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        String[] temp = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(temp[i]);
        Arrays.sort(nums);
        int attack = 1;
        int cnt = 0;
        for (int num : nums) {
            cnt += num % attack == 0 ? num / attack : num / attack + 1;
            attack++;
        }
        System.out.println(cnt);
    }
}
