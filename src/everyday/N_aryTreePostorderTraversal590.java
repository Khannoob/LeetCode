package everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePostorderTraversal590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder2(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node cur = stack.peek();
            if (cur.children != null) {
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            } else {
                ans.add(stack.pop().val);
            }
        }
        return ans;
    }

    public List<Integer> postorder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        if (root != null)
            ans.add(root.val);
        return ans;
    }

    private void dfs(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            dfs(child, ans);
            ans.add(child.val);
        }
    }
}
