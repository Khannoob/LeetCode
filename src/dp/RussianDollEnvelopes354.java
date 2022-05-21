package dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        int[] h = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            h[i] = envelopes[i][1];
        }
        return lengthOfLIS(h);
    }
    public int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            // 要处理的扑克牌
            int poker = nums[i];
            int left = 0, right = piles;
            // 二分查找插入位置
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker)
                    right = mid;
                else
                    left = mid + 1;
            }
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }
}
