package window;

import java.util.Arrays;

public class MovingMedianWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        for (int i = k - 1; i < nums.length; i++) {
            int[] copy = Arrays.copyOfRange(nums, i - k + 1, i);

        }
        return null;
    }
}
