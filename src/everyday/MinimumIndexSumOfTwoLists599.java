package everyday;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumIndexSumOfTwoLists599 {
    //要计算索引和 用map
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (i + map.get(list2[i]) < minIndexSum) {
                    minIndexSum = i + map.get(list2[i]);
                    ans.clear();
                    ans.add(list2[i]);
                }else if (i + map.get(list2[i]) == minIndexSum) {
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}
