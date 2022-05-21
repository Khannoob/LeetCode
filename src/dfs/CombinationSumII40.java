package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII40 {
    List<List<Integer>> res = new ArrayList();
    LinkedList<Integer> track = new LinkedList();
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        Arrays.sort(candidates);
        return res;
    }
    void backtrack(int[] candidates, int target, int start){
        if(sum==target){
            res.add(new LinkedList(track));
            return;
        }
        if(sum>target) return;
        for(int i = start; i<candidates.length; i++){
            if(i > start && candidates[i]==candidates[i-1]) continue;
            //做选择
            sum+=candidates[i];
            track.add(candidates[i]);
            backtrack(candidates, target, i+1);
            sum-=candidates[i];
            track.removeLast();
        }
    }
}
