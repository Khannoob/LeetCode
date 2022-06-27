package window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        HashMap<Character,Integer> window = new HashMap();
        HashMap<Character,Integer> need = new HashMap();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while(right < s.length()){
            //扩大窗口
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))) valid++;
            }
            //缩小窗口
            while(right - left >= p.length()){
                if(valid==need.size()) res.add(left);
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))) valid--;
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return res;
    }
}
