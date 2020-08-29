package offer0826;

/**
 * @author: celeste
 * @create: 2020-08-26 16:37
 * @description:
 * 题目：剑指 Offer 49. 丑数
 * 描述：我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 **/
public class NthUglyNumber {
    /**
     * 一、遍历计算是否可以完全被2，3，5除就是丑数，就加一，然后算到n个丑数就结束
     * 这个方法叫三指针，一个是*2的位置，一个是*3的位置，一个是*5的位置
     * 每一个数字都是2 3 5之间的乘积，就是选择每个已经算好的位置然后*2*3*5中最小的数字
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++){
            int temp = Math.min(ugly[i2] * 2, ugly[i3] * 3);
            ugly[i] = Math.min(temp, ugly[i5] * 5);
            if (ugly[i] == ugly[i2] * 2) i2++;
            if (ugly[i] == ugly[i3] * 3) i3++;
            if (ugly[i] == ugly[i5] * 5) i5++;
        }
        return ugly[n - 1];

    }
}
