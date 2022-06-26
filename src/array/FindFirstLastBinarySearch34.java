package array;

public class FindFirstLastBinarySearch34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }

    int findLeft(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                //收缩范围找最左而不是直接返回
                right = mid - 1;
            }else if(nums[mid] > target){//向左
                right = mid - 1;
            }else if(nums[mid] < target){//向右
                left = mid + 1;
            }
        }
        //如果找不到 防止溢出
        if(left >= nums.length || nums[left]!=target)
            return -1;
        return left;
    }

    int findRight(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                //收缩范围找最右而不是直接返回
                left = mid + 1;
            }else if(nums[mid] > target){//向左
                right = mid - 1;
            }else if(nums[mid] < target){//向右
                left = mid + 1;
            }
        }
        if(right < 0 || nums[right]!=target)
            return -1;
        return right;
    }
}
