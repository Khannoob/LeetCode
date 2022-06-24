package array;

public class RangeAddition370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference diff = new Difference(nums);
        for(int[] update : updates){
            diff.increment(update[0], update[1], update[2]);
        }
        return diff.result();
    }

    class Difference{
        int[] diff;
        Difference(int[] nums){
            diff = new int[nums.length];
            diff[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                diff[i] = nums[i] - nums[i-1];
            }
        }

        void increment(int i, int j, int val){
            diff[i]+=val;
            if(j + 1 < diff.length){
                diff[j+1]-=val;
            }
        }

        int[] result(){
            int[] nums = new int[diff.length];
            nums[0] = diff[0];
            for(int i = 1; i< diff.length; i++){
                nums[i] = nums[i-1] + diff[i];
            }
            return nums;
        }
    }
}
