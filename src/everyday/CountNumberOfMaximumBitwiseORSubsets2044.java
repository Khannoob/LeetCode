package everyday;

public class CountNumberOfMaximumBitwiseORSubsets2044 {
    public static void main(String[] args) {
        CountNumberOfMaximumBitwiseORSubsets2044 ct = new CountNumberOfMaximumBitwiseORSubsets2044();
        int[] nums = {1, 3};
        System.out.println(ct.countMaxOrSubsets(nums));
    }

    //非空子集有2^n 个,当第k位被选取,nums[k]需要求或
    public int countMaxOrSubsets(int[] nums) {
        int cnt = 0;
        int maxOr = 0;
        int subset = 1 << nums.length;
        for (int i = 0; i < subset; i++) {
            int tempOr = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) //i转换成二进制,0/1代表nums数组的位置的状态,在第j位为1表示第j为被选,这时候的或要计算
                    tempOr |= nums[j];
            }
            if (tempOr > maxOr) {
                maxOr = tempOr;
                cnt = 1;
            } else if (tempOr == maxOr) {
                cnt++;
            }
        }
        return cnt;
    }
}
