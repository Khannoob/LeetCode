package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock752 {
    String plusOne(String s, int j){
        char[] arr = s.toCharArray();
        if(arr[j]=='9') arr[j] = '0';
        else arr[j]+=1;
        return new String(arr);
    }


    String minusOne(String s, int j){
        char[] arr = s.toCharArray();
        if(arr[j]=='0') arr[j] = '9';
        else arr[j]-=1;
        return new String(arr);
    }


    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        q.offer("0000");
        visited.add("0000");
        int step = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                String cur = q.poll();
                if(deads.contains(cur)) continue;
                if(cur.equals(target)) return step;
                for(int j = 0; j < 4; j++){
                    String up = plusOne(cur,j);
                    String down = minusOne(cur,j);
                    if(!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    if(!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
