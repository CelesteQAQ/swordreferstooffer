package offer0815;

/**
 * @author: celeste
 * @create: 2020-08-15 16:17
 * @description:
 * 题目：剑指 Offer 14- II. 剪绳子 II
 * 描述：给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 **/
public class CuttingRope2 {
    /**
     * 跟前面的题区别在哪？
     * 多了一个取模吗？
     * 对，因为这样可以算多几个数字
     */
    public int cuttingRope(int n) {
        if (n <= 3){
            return n - 1;
        }
        long sum = 1;
        while (n > 4){
            sum = sum * 3;
            sum = sum  % 1000000007;//注意每个sum都需要处理
            n -= 3;
        }
        return (int)(sum * n  % 1000000007);//最后结果需要转换回int类型
    }


}
