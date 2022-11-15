

public class Huawei {

    public static void main(String[] args) {
        Huawei test = new Huawei();
        System.out.println(test.plant(5, 3));
    }

    //每一个花只能种一个花圃, 花圃数量大于花数量
    int[] res = {0};
    int n;

    int plant(int m, int n) {
        if (m <= 2) return 1;
        boolean[] used = new boolean[m];
        this.n = n;
        traverse(used, m, 0);
        return res[0];
    }

    void traverse(boolean[] used, int m, int flower) {
        //base case
        if (flower == n) {
            res[0]++;
        }
        for (int i = 0; i < m; i++) {
            if (!used[i] && flower % m != i) {
                used[i] = true;
                traverse(used, m, flower + 1);
                used[i] = false;
            }
        }
    }

}
