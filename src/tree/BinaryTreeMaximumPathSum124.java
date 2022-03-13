package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.initBinaryTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);
        root.show(root);
        BinaryTreeMaximumPathSum124 bt = new BinaryTreeMaximumPathSum124();
        System.out.println(bt.maxPathSum(root));
    }

    static class TreeNode {
        // 用于获得树的层数
        private static int getTreeDepth(TreeNode root) {
            return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
        }

        private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
            // 保证输入的树不为空
            if (currNode == null) return;
            // 先将当前节点保存到二维数组中
            res[rowIndex][columnIndex] = String.valueOf(currNode.val);

            // 计算当前位于树的第几层
            int currLevel = ((rowIndex + 1) / 2);
            // 若到了最后一层，则返回
            if (currLevel == treeDepth) return;
            // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
            int gap = treeDepth - currLevel - 1;

            // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
            if (currNode.left != null) {
                res[rowIndex + 1][columnIndex - gap] = "/";
                writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
            }

            // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
            if (currNode.right != null) {
                res[rowIndex + 1][columnIndex + gap] = "\\";
                writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
            }
        }


        public void show(TreeNode root) {
            if (root == null) {
                System.out.println("EMPTY!");
                return;
            }
            // 得到树的深度
            int treeDepth = getTreeDepth(root);

            // 最后一行的宽度为2的（n - 1）次方乘3，再加1
            // 作为整个二维数组的宽度
            int arrayHeight = treeDepth * 2 - 1;
            int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
            // 用一个字符串数组来存储每个位置应显示的元素
            String[][] res = new String[arrayHeight][arrayWidth];
            // 对数组进行初始化，默认为一个空格
            for (int i = 0; i < arrayHeight; i++) {
                for (int j = 0; j < arrayWidth; j++) {
                    res[i][j] = " ";
                }
            }

            // 从根节点开始，递归处理整个树
            // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
            writeArray(root, 0, arrayWidth / 2, res, treeDepth);

            // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
            for (String[] line : res) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < line.length; i++) {
                    sb.append(line[i]);
                    if (line[i].length() > 1 && i <= line.length - 1) {
                        i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                    }
                }
                System.out.println(sb.toString());
            }
        }

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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null)
            return 0;
        //贡献大于0才加入
        int leftMaxGain = Math.max(maxGain(root.left), 0);
        int rightMaxGain = Math.max(maxGain(root.right), 0);
        int curPath = leftMaxGain + rightMaxGain + root.val;
        maxSum = Math.max(curPath, maxSum);
        //左右子树选一个
        return root.val+Math.max(leftMaxGain, rightMaxGain);
    }
}
