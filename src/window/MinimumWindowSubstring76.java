package window;

import java.util.HashMap;

public class MinimumWindowSubstring76 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> window = new HashMap();
        HashMap<Character,Integer> need = new HashMap();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        //双指针
        int left = 0, right = 0;
        //窗口开始的起点/长度  window中满足条件的char数
        int start = 0, len = Integer.MAX_VALUE, cnt = 0;
        while(right < s.length()){
            //扩大窗口
            char c  = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))) cnt++; //重复key
            }
            while(cnt == need.size()){
                if(len > right - left){
                    start = left;
                    len = right - left;
                }
                //缩小窗口
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))) cnt--; //重复key
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
