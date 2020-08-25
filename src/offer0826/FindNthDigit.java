package offer0826;

/**
 * @author: celeste
 * @create: 2020-08-26 02:08
 * @description:
 * 题目：剑指 Offer 44. 数字序列中某一位的数字
 * 描述：数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 **/
public class FindNthDigit {
    /**
     * 按照不同的位数来算有多少个数字，然后计算1位是9个，2位是90个，3位是2700个
     * 然后反推导得到数字是什么
     * 再求出是数字的第几位
     * @param n
     * @return
     */
    public int findNthDigit(int n){
        if (n <= 9) return n;
        n -= 9;
        double count = 90, dig = 2;
        //得到是那几位数字中的值
        while (n > count * dig){
            n -= count * dig;
            count *= 10;
            dig++;
        }
        //反推导得到原本的数字，因为一个数字占dig位置
        double num = Math.pow(10, dig - 1) + n / dig;
        //如果刚刚好就返回前一个数字的最后一位
        if (n / dig == 0){
            num--;
            return (int) num % 10;
        }else{
            //否则返回第几位的数字
            for (int i = 0; i < dig - n % dig; i++){
                num /= 10;
            }
            return (int) num % 10;
        }
    }
}
