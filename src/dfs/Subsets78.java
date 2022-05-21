package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets78 {
    List<List<Integer>> res = new ArrayList();
    LinkedList<Integer> track = new LinkedList();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }
    void backtrack(int[] nums, int start){
        //base case
        res.add(new LinkedList(track));
        for(int i = start; i<nums.length; i++){
            //选择
            track.add(nums[i]);
            backtrack(nums,i+1);
            //撤销选择
            track.removeLast();
        }
    }
}
