package offer0815;

import java.util.Arrays;

/**
 * @author: celeste
 * @create: 2020-08-15 21:54
 * @description:
 * 题目：372. 超级次方
 * 描述：你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 示例 1:
 * 输入: a = 2, b = [3]
 * 输出: 8
 **/
public class SuperPow {
    public int superPow(int a, int[] b) {

        int b_len = b.length;
        if (b_len == 0) return  1;
        return superP(a, b, b_len - 1);
//        int[] b1 = new int[b_len - 1];
//        int[] b1 = Arrays.copyOfRange(b, 0, b_len - 1);
//        int part1 = myPow(a, b[b_len - 1]);
//        int part2 = myPow(superPow(a, b1), 10);
//        return (part1 * part2) % 1337;


    }

    private int superP(int a, int[] b, int i) {
        if (i < 0) return 1;
        int part1 = myPow(a, b[i]);
        int part2 = myPow(superP(a, b, i - 1), 10);
        return part1 * part2 % 1337;
    }

    /**
     * 问题出在这个求幂值的函数，前面的不合适，需要用这种
     * @param a
     * @param n
     * @return
     */

    public int myPow(int a, int n) {
         if(n == 0){
             return 1;
         }
         a %= 1337;
         int ans = 1;
         int x = a;
         while(n>0){
             if(n % 2 == 1){
                 ans = ans * x % 1337;
             }
             x = x * x % 1337;
             n /= 2;
         }
         return ans % 1337;
    }

    /**
     * 另一种写法，从前面往后面遍历b数组
     * @param a
     * @param b
     * @return
     */
    public int superPow_1(int a, int[] b) {
        int r = 1;
        for (int i : b){
            int m = myPow(r, 10) % 1337;//越往后就需要一直求10次方
            int n = myPow(a, i) % 1337;
            r =  m * n % 1337;
        }
        return r;
    }

}
