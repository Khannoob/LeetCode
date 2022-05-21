package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations77 {
    List<List<Integer>> res = new ArrayList();
    LinkedList<Integer> track = new LinkedList();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,1);
        return res;
    }
    void backtrack(int n, int k, int start){
        //base case
        if(track.size()==k){
            res.add(new LinkedList(track));
            return;
        }
        for(int i = start; i<=n; i++){
            //选择
            track.add(i);
            backtrack(n,k,i+1);
            //撤销选择
            track.removeLast();
        }
    }
}
