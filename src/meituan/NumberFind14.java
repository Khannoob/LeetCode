package meituan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NumberFind14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<Integer> list = numberFind(s);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    static ArrayList<Integer> numberFind(String s) {
        char[] chars = s.toCharArray();
        boolean preNum = false;
        StringBuilder temp = new StringBuilder();
        ArrayList<Integer> res = new ArrayList<>();
        for (char aChar : chars) {
            if (aChar <= 57 && aChar >= 48) {
                preNum = true;
                temp.append(aChar);
            } else {
                if (preNum) res.add(Integer.parseInt(temp.toString()));
                preNum = false;
                temp.delete(0, temp.length());
            }
        }
        if (!temp.isEmpty()) res.add(Integer.parseInt(temp.toString()));
        res.sort(Comparator.comparingInt(a -> a));
        return res;
    }
}
