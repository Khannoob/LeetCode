package window;

import java.util.ArrayList;
import java.util.LinkedList;

public class SlidingWindowMaximum239 {
    //用单调队列(双向链表)数据结构实现O(1)
    public int[] maxSlidingWindow(int[] nums, int k) {
        //框架代码
        ArrayList<Integer> res = new ArrayList<>();
        MonotonicQueue window = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            //当i小于k-1的时候直接push进window
            while (i < k - 1) {
                window.push(nums[i]);
                i++;
            }
            //当i=k-1,到达第一个window长度,需要求出一个最大值
            window.push(nums[i]);
            res.add(window.max());
            window.pop(nums[i - k + 1]);//window需要把最左边的移除
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    //单调队列 数据结构
    class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList();

        void push(int n) {
            //直接把<n的链尾全部移除
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            q.addLast(n);
        }

        void pop(int n) {
            //只需要判断是不是链表头,其他的不用管,不是最大值不考虑
            if (q.getFirst() == n) {
                q.removeFirst();
            }
        }

        int max() {
            //返回链表头就是最大值
            return q.getFirst();
        }
    }
}
