package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree111 {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList();
        int depths = 1;
        q.offer(root);
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                TreeNode cur = q.poll();
                if(cur.left==null && cur.right==null) return depths;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            depths++;
        }
        return depths;
    }
}
