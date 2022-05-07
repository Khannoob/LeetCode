package window;

import java.util.Arrays;

public class MovingMedianWindow480x {
    public static void main(String[] args) {
        int[] nums = {2147483647,2147483647};
        double[] doubles = medianSlidingWindow(nums, 2);
        for (int i = 0; i < doubles.length; i++) {
            System.out.print(doubles[i]);
        }
    }
    //暴力
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int idx = 0;
        for (int i = k; i <= nums.length; i++) {
            int[] copy = Arrays.copyOfRange(nums, i - k, i);
            Arrays.sort(copy);
            res[idx++] = getMid(copy);
        }
        return res;
    }

    private static double getMid(int[] copy) {
        if (copy.length % 2 == 1) {
            return copy[copy.length / 2];
        } else {
            int length = copy.length;
            return (double) (copy[length / 2] + copy[length / 2 - 1]) / 2;
        }
    }
}
