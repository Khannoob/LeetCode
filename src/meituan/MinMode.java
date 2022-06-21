package meituan;

import org.w3c.dom.Node;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinMode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]), K = Integer.parseInt(line1[1]);
        String[] line2 = sc.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((t1, t2) -> t1.cnt - t2.cnt == 0 ? t1.num - t2.num : t2.cnt - t1.cnt);
        for (int i = 0; i < K - 1; i++) {
            queue.offer(new Node(nums[i]));
        }

        for (int i = 0; i < n - K + 1; i++) {
            queue.add(new Node(nums[i + K - 1]));
            System.out.println(queue.peek().num);
            Node.remove(nums[i]);
        }
    }

    static class Node {
        static HashMap<Integer, Integer> map = new HashMap<>();

        public Node(int num) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.replace(num, map.get(num)+1);
            this.num = num;
            this.cnt = map.get(num);
        }

        static void remove(int num) {
            map.remove(num);
        }

        int num;
        int cnt;
    }
}
