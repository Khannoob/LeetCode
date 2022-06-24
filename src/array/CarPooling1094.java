package array;

public class CarPooling1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] station = new int[1001];
        Difference diff = new Difference(station);
        for(int[] trip : trips){
            int val = trip[0];
            int start = trip[1];
            int end = trip[2]-1;
            diff.increment(start,end,val);
        }
        int[] result = diff.result();
        for(int i = 0; i < result.length; i++){
            if (capacity < result[i]) return false;
        }
        return true;
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
            if(j+1< diff.length){
                diff[j+1]-=val;
            }
        }
        int[] result(){
            int[] nums = new int[diff.length];
            nums[0] = diff[0];
            for(int i =1; i<diff.length; i++){
                nums[i] = nums[i-1]+diff[i];
            }
            return nums;
        }
    }
}
