package array;

public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while(slow<nums.length){
            nums[slow] = 0;
            slow++;
        }
    }
}
