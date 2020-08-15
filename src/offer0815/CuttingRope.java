package offer0815;

/**
 * @author: celeste
 * @create: 2020-08-15 14:53
 * @description:
 * 题目：剑指 Offer 14- I. 剪绳子
 * 描述：给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 **/
public class CuttingRope {
    /**
     * 切成m段，m可以是2到n-1
     * 那么刀子的位置是可以不一样的，还有刀子的位置，但是只需要循环一半
     * 可以使用动态规划的方法来做
     * 1 到 n建立一个数组，数组里面是i位置的最大乘积，然后每个位置都可以是两个数的乘积
     * 就是从第一个（与倒数第一个），因为和要为当前位置，然后选择下标和数组值中最大的来乘
     */
    public int cuttingRope(int n){
        if (n <= 1){
            return 0;
        }
        int[] state = new int[n];
        for (int i = 1; i < n; i++){//注意下标是比自身要小1
            int left = 0;
            int right = i - 1;
            while (left <= right){
                int temp = Math.max(left + 1, state[left])
                        * Math.max(right + 1, state[right]);
                state[i] = Math.max(temp, state[i]);
                left++;
                right--;
            }
        }
        return state[n - 1];
    }

    /**
     * 评论里面的答案，3是最优秀的因子，可以直接使用按照3来切
     * @param n
     * @return
     */
    public int cuttingRope_1(int n) {
        if (n <= 3){
            return n - 1;
        }
        int sum = 1;
        while (n > 4){
            sum *= 3;
            n -= 3;
        }
        return sum * n;
    }
}
