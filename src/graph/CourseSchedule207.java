package graph;

import java.util.LinkedList;

public class CourseSchedule207 {
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            traversal(graph, i);
        }
        return !hasCycle;
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
        onPath[s] = false;
    }
}
