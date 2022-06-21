package meituan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]), m = Integer.parseInt(line1[1]);
        int[][] nums = new int[m][2];
        String[] temp = sc.nextLine().split(" ");
        int idx = 0;
        for (int i = 0; i < m; i++) {
            nums[i][0] = Integer.parseInt(temp[idx++]);
            nums[i][1] = Integer.parseInt(temp[idx++]);
        }
        System.out.println(length(n, nums));

    }

    static ArrayList<Integer> postorder = new ArrayList();
    static boolean[] visited;
    static boolean[] onPath;
    static boolean hasCycle = false;

    static int length(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traversal(graph, i);
        }
        if (hasCycle) return 0;

        return postorder.size();
    }


    static LinkedList<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1], to = prerequisites[i][0];
            graph[from].add(to);
        }
        return graph;
    }

    static void traversal(LinkedList<Integer>[] graph, int s) {
        if (onPath[s]) {
            hasCycle = true;
        }
        if (visited[s] || hasCycle)
            return;
        visited[s] = true;
        onPath[s] = true;
        for (int neighbor : graph[s]) {
            traversal(graph, neighbor);
        }
        postorder.add(s);
        onPath[s] = false;
    }
}
