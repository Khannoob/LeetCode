package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations46 {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return res;
    }
    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used){
        //结束条件
        if(track.size() == nums.length){
            //引用对象需要重新new
            res.add(new LinkedList(track));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            //前序
            track.add(nums[i]);
            used[i]=true;
            backtrack(nums,track,used);
            track.removeLast();
            used[i]=false;
        }
    }
}
