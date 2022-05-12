package graph;

public class IsGraphBipartite785 {
    //dfs
    boolean flag = true;
    boolean[] color;
    boolean[] visited;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];
        //因为不能确定图中有孤岛所以每一个都得作为起点
        for(int i=0;i<n;i++){
            if(!visited[i])
                traversal(graph,i);
        }
        return flag;
    }
    void traversal(int[][] graph, int n){
        if(!flag) return;
        visited[n] = true;
        for(int neighbor: graph[n]){
            if(!visited[neighbor]){//如果未被访问则进行染色,并遍历邻居
                color[neighbor] = !color[n];
                traversal(graph,neighbor);
            }else{
                if(color[n]==color[neighbor]){
                    flag  = false;
                }
            }
        }
    }
}
