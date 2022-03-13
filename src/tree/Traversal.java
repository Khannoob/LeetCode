package tree;

import java.util.*;

public class Traversal {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static TreeNode initBinaryTree(Integer... treeNodeValues) {
            if (treeNodeValues == null) {
                throw new IllegalArgumentException("treeNodeValues should not be null");
            }
            int nodeCount = treeNodeValues.length;
            if (nodeCount == 0) {
                throw new IllegalArgumentException("treeNodeValues count should not be zero");
            }
            if (treeNodeValues[0] == null) {
                return null;
            }
            TreeNode root = new TreeNode(treeNodeValues[0]);
            List<TreeNode> list = new LinkedList<>();
            list.add(root);
            int index = 1;
            while (!list.isEmpty()) {
                TreeNode node = list.remove(0);
                if (node == null) {
                    continue;
                }
                if (index < nodeCount) {
                    TreeNode left = treeNodeValues[index] == null ? null : new TreeNode(treeNodeValues[index]);
                    node.left = left;
                    list.add(left);
                    index++;
                }
                if (index < nodeCount) {
                    TreeNode right = treeNodeValues[index] == null ? null : new TreeNode(treeNodeValues[index]);
                    node.right = right;
                    list.add(right);
                    index++;
                }
            }
            if (index != nodeCount) {
                throw new IllegalArgumentException("treeNodeValues can not utils.init a binary utils.tree");
            }
            return root;
        }

        public TreeNode getNode(int target) {
            return findNode(this, target);
        }

        private TreeNode findNode(TreeNode root, int target) {
            if (root == null || root.val == target) {
                return root;
            }
            TreeNode leftResult = findNode(root.left, target);
            return leftResult != null ? leftResult : findNode(root.right, target);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }

        @Override
        public String toString() {
            List<String> result = new LinkedList<>();
            List<TreeNode> list = new LinkedList<>();
            list.add(this);
            while (!list.isEmpty()) {
                TreeNode node = list.remove(0);
                result.add(node == null ? "null" : String.valueOf(node.val));
                if (node != null) {
                    list.add(node.left);
                    list.add(node.right);
                }
            }
            int index = result.size() - 1;
            while (index > 0 && "null".equals(result.get(index))) {
                result.remove(index--);
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.initBinaryTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);
        Traversal lt = new Traversal();
        System.out.println(lt.postorderTraversal(treeNode));
        System.out.println(lt.preorderTraversal(treeNode));
        System.out.println(lt.inorderTraversal(treeNode));
    }

    //后序
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();

            if (cur.right != null && cur.right != prev) {
                cur = cur.right;
            } else {
                ans.add(cur.val);
                stack.pop();
                prev = cur;
                cur = null;
            }

        }
        return ans;
    }

    //前序
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                ans.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return ans;
    }
    //中序
    public List<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }
}
