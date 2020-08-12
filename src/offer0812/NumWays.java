package offer0812;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: celeste
 * @create: 2020-08-12 21:37
 * @description:
 * 题目：剑指 Offer 10- II. 青蛙跳台阶问题
 * 描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 **/
public class NumWays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        // 读取输入，注意next是读取字符串，直到空格为止；
        // nextInt是读取数字；
        // nextLine是读取一整行字符串
        //
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> t = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            ArrayList<Integer> w = new ArrayList<>();
            List<Integer> all = new ArrayList<>();
            for (int j = 0; j < 7; j++) {

                String m = s.next();
                int a = Character.getNumericValue(m.charAt(0));
                char btw = m.charAt(1);
                if (btw == 'T') {
                    if (t.size() >= 1 && (Math.abs(t.get(0) - a) != 3 && Math.abs(t.get(0) - a) != 6)) {
                        System.out.println(false);
                    }
                    t.add(a);
                } else if (btw == 'B') {
                    if (b.size() >= 1 && (Math.abs(b.get(0) - a) != 3 && Math.abs(b.get(0) - a) != 6)) {
                        System.out.println(false);
                    }
                    b.add(a);
                } else if (btw == 'W') {
                    if (w.size() >= 1 && (Math.abs(w.get(0) - a) != 3 && Math.abs(w.get(0) - a) != 6)) {
                        System.out.println(false);
                    }
                    w.add(a);
                }
            }
            //BTW的限制是不可以超过3个
            if (b.size() > 3 || t.size() > 3 || w.size() > 3) {
                System.out.println(false);
                return;
            }
            //将所有都放到一个数组，因为只可以是1到9中的7个，不可以重复
            all.addAll(t);
            all.addAll(b);
            all.addAll(w);
            Arrays.sort(new List[]{all});
            for (int k = 0; k < all.size(); k++) {
                //超出范围为false
                if (all.get(k) < 1 || all.get(k) > 9) {
                    System.out.println(false);
                    return;
                }
                //重复为false
                if (k != 0 && all.get(k) == all.get(k - 1)) {
                    System.out.println(false);
                    return;
                }
            }
            System.out.println(true);
        }
    }
}
