package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class CourseScheduleII210 {
    ArrayList<Integer> postorder = new ArrayList();
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            traversal(graph, i);
        }
        if(hasCycle) return new int[]{};

        Collections.reverse(postorder);
        int[] res = new int[postorder.size()];
        for(int i=0; i<postorder.size(); i++){
            res[i] = postorder.get(i);
        }
        return res;
    }


    LinkedList<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for(int i=0; i<numCourses;i++){
            graph[i] = new LinkedList();
        }
        for(int i=0;i<prerequisites.length;i++){
            int from = prerequisites[i][1], to = prerequisites[i][0];
            graph[from].add(to);
        }
        return graph;
    }
    void traversal(LinkedList<Integer>[] graph, int s){
        if(onPath[s]){
            hasCycle = true;
        }
        if(visited[s] || hasCycle)
            return;
        visited[s] = true;
        onPath[s] = true;
        for(int neighbor: graph[s]){
            traversal(graph,neighbor);
        }
        postorder.add(s);
        onPath[s] = false;
    }
}
