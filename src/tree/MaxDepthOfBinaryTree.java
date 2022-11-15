package tree;

public class MaxDepthOfBinaryTree {
    //这个递归函数的定义:寻找左右子树的最大深度 max(right,left)+1 1是根节点的深度
    public int maxDepth(TreeNode root) {
        //base case
        if(root==null)  return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
