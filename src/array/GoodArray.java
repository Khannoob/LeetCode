package array;

public class GoodArray {
    public static void main(String[] args) {
        int[][] queries = new int[2][3];
        goodArray(26, queries);
    }
     static int[] goodArray(int N, int[][] queries) {
        int length = queries.length;
        int[] res = new int[length];
        String string = Integer.toBinaryString(N);
        String substring = string.substring(string.indexOf("1"));
        System.out.println("substring = " + substring);
        return res;
    }
}
