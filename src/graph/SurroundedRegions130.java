package graph;

public class SurroundedRegions130 {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        //把边缘节点全部加入dummy UF，然后将非孤岛 'O' union到dummy,剩余非connected的为孤岛
        int m = board.length;
        int n = board[0].length;
        //将二维转为一维 [0,m*n-1] m*n是dummy
        UF uf = new UF(m * n + 1);
        int dummy = m * n;
        //将首列和末列的O union到dummy
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                uf.union(dummy, i * n);
            if (board[i][n - 1] == 'O')
                uf.union(dummy, i * n + n - 1);
        }
        //首行末行
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                uf.union(j, dummy);
            if (board[m - 1][j] == 'O')
                uf.union((m - 1) * n + j, dummy);
        }
        //找出非四边,上下左右4个位置的进行Union
        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; i < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O') {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; i < n - 1; j++) {
                if (!uf.connected(dummy, i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }

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
