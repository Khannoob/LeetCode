package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII90 {
    List<List<Integer>> res = new ArrayList();
    LinkedList<Integer> track = new LinkedList();
    //把nums排好序,然后相邻且相等的数跳过
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0);
        return res;
    }
    void backtrack(int[] nums,int start){
        //无case base条件
        res.add(new LinkedList(track));
        for(int i= start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1])
                continue;
            //选择
            track.addLast(nums[i]);
            backtrack(nums,i+1);
            track.removeLast();
        }
    }
}
