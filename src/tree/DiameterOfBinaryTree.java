package tree;

public class DiameterOfBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root){
        if(root==null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        traverse(root.left);
        traverse(root.right);
    }
}
