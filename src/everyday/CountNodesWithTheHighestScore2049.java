package everyday;

import java.util.ArrayList;
import java.util.List;

public class CountNodesWithTheHighestScore2049 {
    //dfs
    List<Integer>[] children;//某节点的子节点
    int n;//总结点数
    int cnt;//最高分的个数
    long maxScore;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        //初始化所有子节点集合
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        //往子节点集合中放对应当前parent节点的子节点
        for (int i = 0; i < n; i++) {
            if (parents[i] != -1) {
                children[parents[i]].add(i);//所有有子节点的子节点都放在了list中
            }
        }
        dfs(0);//dfs是求当前节点的子节点个数
        return cnt;
    }

    private int dfs(int node) {
        int size = n - 1;
        long score = 1;
        for (Integer c : children[node]) {
            int t = dfs(c);
            score *= t;
            size -= t;//size是除了子节点以外的节点数
        }
        //根节点除了子节点以外没有其余节点
        if (node != 0) {
            score *= size; // 左子树 * 右子树 * 根以外子树
        }
        if (score == maxScore) {
            cnt++;
        } else if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }
        return n-size;
    }
}
