package tree;

public class SerializeAndDeserializeBinaryTree297 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode() {
        }
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree297 sa = new SerializeAndDeserializeBinaryTree297();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        System.out.println(sa.serialize(treeNode));
        sa.deserialize(sa.serialize(treeNode));
    }

    // Encodes a tree to a single string.  前序遍历
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        int[] index = {0};
        return dfs(split, index);
    }

    TreeNode dfs(String[] arr, int[] idx) {
        if (arr[idx[0]].equals("#")) {
            idx[0]++;
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = Integer.parseInt(arr[idx[0]]);
        idx[0]++;
        node.left = dfs(arr, idx);
        node.right = dfs(arr, idx);
        return node;
    }
}
