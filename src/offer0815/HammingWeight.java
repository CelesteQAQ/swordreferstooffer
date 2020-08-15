package offer0815;

/**
 * @author: celeste
 * @create: 2020-08-15 17:04
 * @description:
 * 题目：剑指 Offer 15. 二进制中1的个数
 * 描述：请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 **/
public class HammingWeight {
    /**
     * 就是需要找出2……n中的系数
     * 不会处理无符号数，但是二进制首先考虑n & (n - 1)
     */
    public int hammingWeight(int n){
        int temp = 1;
        for (int i = 0; i < n; i++){

            if (temp <= n && temp * 2 > n){
                return 1 + hammingWeight(n - temp);
            }else if (n > temp){
                temp *= 2;
            }else if (n == 0){
                return 0;
            }
        }
        return 0;
    }

    public int hammingWeight_1(int n) {
        int result = 0;
        while (n != 0){
            n = n & (n - 1);
            result++;

        }
        return result;
    }

}
