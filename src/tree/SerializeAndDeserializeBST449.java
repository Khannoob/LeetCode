package tree;

import java.util.LinkedList;

public class SerializeAndDeserializeBST449 {
    //BST左小右大 利用 min, max 边界来划定一棵子树的边界，从而提升算法效率
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
        SerializeAndDeserializeBST449 sa = new SerializeAndDeserializeBST449();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        System.out.println(sa.serialize(treeNode));
        sa.deserialize(sa.serialize(treeNode));
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        // 前序遍历位置进行序列化
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        String[] split = data.split(",");
        LinkedList<Integer> inorder = new LinkedList<>();//用链表是因为可以少维护一个idx
        for (String s : split) {
            inorder.offer(Integer.parseInt(s));
        }
        return deserialize(inorder, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    TreeNode deserialize(LinkedList<Integer> inorder, int max, int min) {
        if (inorder.isEmpty() || inorder.getFirst() > max || inorder.getFirst() < min)
            return null;
        Integer rootVal = inorder.pollFirst();
        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = deserialize(inorder, rootVal, min);
        treeNode.right = deserialize(inorder, max, rootVal);
        return treeNode;
    }
}
