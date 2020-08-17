package offer0815;

/**
 * @author: celeste
 * @create: 2020-08-15 20:53
 * @description:
 * 题目：剑指 Offer 16. 数值的整数次方
 * 描述：实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 **/
public class MyPow {

    /**
     * 这个是超级幂的算法
     * 如果需要计算x的64次方不需要进行64次惩罚，可以将这次的结果平方，可以只进行6次平方操作
     * 求指数为n的快速幂时：
     * （1）当n为偶数，即求两个指数为n/2的快速幂的积；
     * （2）当n为奇数，即求两个指数为n/2的快速幂的积再乘1个底数。
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x, n / 2);//求两个指数为n/2的快速幂的积
        double mod = myPow(x, n % 2);//再找1个底数
        return half * half * mod;

    }
}
