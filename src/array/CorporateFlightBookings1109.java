package array;

public class CorporateFlightBookings1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flight = new int[n];
        Difference diff  = new Difference(flight);
        for(int[] booking : bookings){
            diff.increment(booking[0]-1, booking[1]-1, booking[2]);
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
