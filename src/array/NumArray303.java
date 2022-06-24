package array;

public class NumArray303 {
    int[] presum;
    //定义一个累加和的数组
    public NumArray303(int[] nums) {
        presum = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            presum[i+1] = presum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return presum[right+1] - presum[left];
    }
}
