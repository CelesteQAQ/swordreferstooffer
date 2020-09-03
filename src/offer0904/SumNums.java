package offer0904;

/**
 * @author: celeste
 * @create: 2020-09-04 02:57
 * @description:
 * 题目：剑指 Offer 64. 求1+2+…+n
 * 描述：求 1+2+...+n ，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 **/
public class SumNums {
    /**
     * 递归
     * 关键在于使用一个boolean数再&&这样不成立就不用计算后面
     * @param n
     * @return
     */
    public int sumNums (int n){
        int sum = n;
        boolean flag = n > 0 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
