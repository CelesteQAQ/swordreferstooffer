package offer0905;

/**
 * @author: celeste
 * @create: 2020-09-05 01:03
 * @description:
 * 题目：剑指 Offer 65. 不用加减乘除做加法
 * 描述：写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 **/
public class Add {
    public int add (int a, int b){
        if (b == 0) return a;
        int c = (a & b) << 1;
        int d = a ^ b;
        return add(d, c);
    }
}
