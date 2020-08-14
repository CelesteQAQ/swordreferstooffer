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
 * 斐波那契数列
 * 当前位置是由前一个台阶跳1阶以及前2个台阶跳2阶得到的
 *
 **/
public class NumWays {
    public int numWays(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        if(n <= 1){
            return 1;
        }
        f[1] = 1;
        for (int i = 2; i <= n; i++){
            f[i] = (f[i - 1] + f[i - 2])%1000000007;//记得取模
        }
        return f[n];
    }

}
