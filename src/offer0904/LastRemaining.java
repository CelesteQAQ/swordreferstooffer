package offer0904;

import java.util.ArrayList;

/**
 * @author: celeste
 * @create: 2020-09-04 02:25
 * @description:
 * 题目：剑指 Offer 62. 圆圈中最后剩下的数字
 * 描述：0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 **/
public class LastRemaining {
    /**
     * 边删边调整数组大小
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining (int n, int m){
        ArrayList<Integer> list = new ArrayList<>();
        int ans = 0;
        //将数字添加到数组中
        for (int i = 0; i < n; i++){
            list.add(i);
        }
        while (n > 1){
            //更新要删除的位置，以及数组大小
            ans = (ans + m - 1) % n;
            list.remove(ans);
            n--;
        }
        return list.get(0);
    }

    /**
     * 约瑟夫环的数学解法，从后面往前面推
     * 补上m个数字，再模上当时的数组的大小
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining2(int n, int m){
        int ans = 0;
        for (int i = 2; i <= n; i++){
            ans = (ans + m) % i;
        }
        return ans;
    }
}
