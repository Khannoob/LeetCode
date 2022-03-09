package everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePreorderTraversal589 {
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

    //迭代
    public List<Integer> preorder2(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            Node cur = stack.pop();
            ans.add(cur.val);
            if (cur.children!=null){
                for (int i = cur.children.size()-1; i >=0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
        }
        return ans;
    }

    //dfs
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    private void dfs(List<Integer> ans, Node root) {
        if (root == null)
            return;
        ans.add(root.val);
        for (Node child : root.children) {
            dfs(ans, child);
        }

    }
}
