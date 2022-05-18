package backtrack;

import java.util.Arrays;
import java.util.HashMap;

public class Partition2KEqualSumSubsets698 {
    //以桶的视角
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k>nums.length) return false;
        int sum = 0;
        for(int v : nums) sum+=v;
        if(sum%k!=0) return false;
        int target = sum / k;
        int used = 0;
        Arrays.sort(nums);
        for (int i = 0,j = nums.length - 1; i < j; i++, j--) {
            // 交换 nums[i] 和 nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return backtrack(k,nums,0,used,target,0);
    }
    //记事本
    HashMap<Integer,Boolean> memo = new HashMap();
    boolean backtrack(int k, int[] nums,int bucket, int used, int target, int start){
        //base case
        if(k==0){
            return true;
        }
        if(bucket==target){
            //bucket归零,下一个桶,从数组头开始选数字
            boolean res = backtrack(k-1,nums,0,used,target,0);
            memo.put(used,res);
            return res;
        }
        if (memo.containsKey(used)) {
            // 避免冗余计算
            return memo.get(used);
        }
        for(int i = start; i<nums.length; i++){
            //剪枝
            if(((used >> i)&1) ==1 || bucket+nums[i]>target) continue;
            //做选择
            used |= 1 <<  i;
            bucket+=nums[i];
            //下一个数字
            if(backtrack(k,nums,bucket,used,target,i+1)) return true;
            //撤销选择
            used ^= 1 <<i;
            bucket-=nums[i];
        }
        //该桶无法满足
        return false;
    }
    //以数字的视角
    public boolean canPartitionKSubsets1(int[] nums, int k) {
        if(k > nums.length) return false;
        int[] bucket = new int[k];
        int sum = 0;
        for(int v: nums) sum+=v;
        if(sum%k!=0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        for (int i = 0,j = nums.length - 1; i < j; i++, j--) {
            // 交换 nums[i] 和 nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return backtrack1(nums,bucket,target,0);
    }
    boolean backtrack1(int[] nums, int[] bucket, int target, int idx){
        int k = bucket.length;
        //base case
        if(idx==nums.length){
            //检查是否所有桶都满足
            for(int n = 0; n < k; n++){
                if(bucket[n]!=target) return false;
            }
            return true;
        }
        for(int n = 0; n < k; n++){
            //剪枝
            if(bucket[n] + nums[idx] > target) continue;
            //做选择
            bucket[n]+=nums[idx];
            if(backtrack1(nums,bucket,target,idx+1)) return true;
            //撤销选择(如果不满足base case, 换一个桶)
            bucket[n]-=nums[idx];
        }
        //该数字无满足桶
        return false;
    }
}
