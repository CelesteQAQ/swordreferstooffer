package offer0905;

/**
 * @author: celeste
 * @create: 2020-09-05 01:06
 * @description:
 * 题目：剑指 Offer 66. 构建乘积数组
 * 描述：给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 **/
public class ConstructArr {
    /**
     * 左边乘，右边乘再相乘
     * @param a
     * @return
     */
    public int[] constructArr (int[] a){
        int n = a.length;
        int[] B = new int[n];
        //从左边开始乘当前位置左边的值
        for (int i = 0, product = 1; i < n; product *= a[i], i++){
            B[i] = product;
        }
        //从右边开始乘当前位置的右边的值，与之前的左边的值相乘
        for (int i = 0, product = 1; i >= 0; product *= a[i], i--){
            B[i] *= product;
        }
        return B;
    }
}
