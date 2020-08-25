package offer0826;

/**
 * @author: celeste
 * @create: 2020-08-26 01:23
 * @description:
 * 题目：剑指 Offer 43. 1～n整数中1出现的次数
 * 描述：输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 **/
public class CountDigitOne {
    /**
     * 注意求得是1的个数，所以是可以重复的，每一位都是，11算2次，111算3次
     * 从个位数开始算起，有多少个1
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int count = 0;
        for (double i = 1; i <= n; i *= 10){
            double divider = i * 10;
            count += (int)(n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0), i);
        }
        return count;
    }
}
