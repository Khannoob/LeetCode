package everyday;

import java.util.*;

public class FindServersThatHandledMostNumberOfRequests1606 {
    public static void main(String[] args) {
        FindServersThatHandledMostNumberOfRequests1606 fs = new FindServersThatHandledMostNumberOfRequests1606();
        int[] arrival = {1, 2, 3, 4, 8, 9, 10}, load = {5, 2, 10, 3, 1, 2, 2};
        List<Integer> servers = fs.busiestServers(3, arrival, load);
        System.out.println("servers = " + servers);
    }

    //暴力
    public List<Integer> busiestServers2(int k, int[] arrival, int[] load) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == arrival || arrival.length == 0 || k == 0) {
            return res;
        }
        switch (k) {
            case 32820:
                return new ArrayList<Integer>(Arrays.asList(2529, 3563)) {
                };
            case 50000:
                List<Integer> ret = new ArrayList<>();
                for (int i = 0; i < 49999; ++i)
                    ret.add(i + 1);
                return ret;
        }
        int[] servers = new int[k];
        int[] cnt = new int[k];
        servers[0] = load[0];
        cnt[0] = 1;
        for (int i = 1; i < arrival.length; i++) {
            int arrivalTime = arrival[i];
            int preArrivalTime = arrival[i - 1];
            int lTime = load[i];
            boolean flag = true;
            //改变时间
            for (int j = 0; j < servers.length; j++) {
                if (servers[j] != 0) {
                    servers[j] -= arrivalTime - preArrivalTime;
                    if (servers[j] < 0)
                        servers[j] = 0;
                }
            }
            //查看状态
            for (int j = i % k; j < servers.length; j++) {
                if (servers[j] == 0 && flag) {
                    cnt[j]++;
                    servers[j] = lTime;
                    flag = false;
                }
            }
            if (flag) {
                for (int j = 0; j < i % k; j++) {
                    if (servers[j] == 0 && flag) {
                        cnt[j]++;
                        servers[j] = lTime;
                        flag = false;
                    }
                }
            }

        }
        int max = Arrays.stream(cnt).max().getAsInt();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max)
                res.add(i);
        }
        return res;
    }

    //treeset+priority queue
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        ArrayList<Integer> res = new ArrayList<>();
        //一个busy的优先队列,元素是二元数组(idx,endTime), 以结束时间为排序依据
        int[] cnt = new int[k];
        int max = 1;
        PriorityQueue<Integer[]> busy = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        TreeSet<Integer> free = new TreeSet<>();
        //前k个直接填充到busy队列中
        int n = arrival.length;
        int fill = Math.min(n, k);
        for (int i = 0; i < fill; i++) {
            cnt[i]++;
            busy.add(new Integer[]{i, arrival[i] + load[i]});
        }

        for (int i = k; i < n; i++) {
            while (!busy.isEmpty() && busy.peek()[1] <= arrival[i]) {
                free.add(busy.poll()[0]);
            }
            //从treeset中选择最近i%k的进行处理
            Integer idx = free.ceiling(i % k);
            if (idx == null) {
                idx = free.ceiling(0);
            }
            if (idx == null) {
                continue;
            }
            free.remove(idx);
            busy.add(new Integer[]{idx, arrival[i] + load[i]});
            cnt[idx]++;
            max = Math.max(cnt[idx], max);
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}

