package array;

public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i =0; i < s.length(); i++){
            String s1 = findPalindrome(s,i,i);//奇数
            String s2 = findPalindrome(s,i,i+1);//偶数
            res = res.length() < s1.length() ? s1 : res;
            res = res.length() < s2.length() ? s2 : res;
        }
        return res;
    }
    String findPalindrome(String s, int l, int r){
        while(l>=0 && r<s.length()
                && s.charAt(l) == s.charAt(r))
        {
            r++;
            l--;
        }
        return s.substring(l+1,r);
    }

}
