package tree;

public class SerializeAndDeserializeBinaryTree297 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // Encodes a tree to a single string.  前序遍历
    public String serialize(TreeNode root) {
        if (root==null)
            return "#";
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        int[] index = {0};
        return dfs(split,index);
    }
    private TreeNode dfs(String[] split, int[] index){
        String s = split[index[0]];
        index[0]++;
        if (s.equals("#"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = dfs(split, index);
        node.right = dfs(split, index);
        return node;
    }
}
