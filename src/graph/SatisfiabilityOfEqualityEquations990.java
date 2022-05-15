package graph;

public class SatisfiabilityOfEqualityEquations990 {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for(String s:equations){
            if(s.charAt(1)=='='){
                char x = s.charAt(0);
                char y = s.charAt(3);
                uf.union(x-'a',y-'a');
            }
        }
        for(String s:equations){
            if(s.charAt(1)=='!'){
                char x = s.charAt(0);
                char y = s.charAt(3);
                if(uf.connected(x-'a',y-'a'))
                    return false;
            }
        }
        return true;
    }

    class UF {
        int[] parent;
        int count;

        public UF(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }

        private int find(int x) {//返回父节点值
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            //压缩树的高度

            return parent[x];
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public int count() {
            return count;
        }
    }
}
