package everyday;

//字典树
public class KthSmallestInLexicographicalOrder440 {
    public static void main(String[] args) {
        KthSmallestInLexicographicalOrder440 ks = new KthSmallestInLexicographicalOrder440();
        System.out.println(ks.findKthNumber(10, 3));
    }

    //确定某一个前缀prefix下面的子节点个数,用于判断前缀需要往下走还是往右走
    //如果子节点个数(包括自己)<第k,比如prefix=1下面有10节点,但是k=12,那么不在1下面而在2下面,那么prefix++,往右走
    //相反,如果k=3,1下面有4节点满足cnt<=k,那么就在当前前缀下面
    public int findKthNumber(int n, int k) {
        int prefix = 1;//要遍历的前缀,从1开始
        int cnt = 1;//经历过的节点数

        while (cnt < k) {//当cnt等于k的时候就找到了
            int node = getNode(n, prefix);
            if (cnt + node <= k) {//往右走
                prefix++;
                cnt += node;//把前一个前缀的所有节点都加上
            } else {//往下走
                prefix *= 10;
                cnt++;//只经历了根节点一个节点,所以加一
            }
        }
        return prefix;//前缀在不断逼近
    }

    //难点2.获取某前缀的所有节点数 不断深入
    private int getNode(int n, int prefix) {
        long cur = prefix;
        long next = prefix + 1;
        int node = 0;
        while (cur <= n) {//10子树的情况node += next - cur 和 非10子树的情况不满足,这个时候和n相关,是node += n+1 - cur;
            node += Math.min(next, n + 1) - cur;
            cur *= 10;
            next *= 10;
        }
        return node;
    }
}
