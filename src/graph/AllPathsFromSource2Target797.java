package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSource2Target797 {
    //dfs
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traversal(graph, 0, path);
        return res;
    }

    void traversal(int[][] graph, int node, LinkedList<Integer> path) {
        path.addLast(node);
        if (node == graph.length - 1) {
            res.add(new LinkedList<>(path));
            path.clear();
            return;
        }
        for (int neighbor : graph[node]) {
            traversal(graph, neighbor, path);
        }
        path.removeLast();
    }
}
