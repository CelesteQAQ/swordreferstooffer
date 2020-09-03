package offer0902;

import offer0901.MaxSlidingWindow;

/**
 * @author: celeste
 * @create: 2020-09-02 02:03
 * @description:
 * 题目：剑指 Offer 60. n个骰子的点数
 * 描述：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 123456 1/6
 * 123456 123456 2 。。。12
 * 123456 123456 123456   3。。。18
 **/
public class TwoSum {
    /**
     * 动态规划方法
     * 使用数组去将每个n叠加的和记录下来
     * @param n
     * @return
     */
    public double[] twoSum(int n){
        double[] ans = new double[5 * n + 1];
        //记录叠加的和
        double[][] state = new double[n + 1][6 * n + 1];
        double len = Math.pow(6, n);
        //初始化n=1而不是n=0
        for (int i = 1; i <= 6; i++){
            state[1][i] = 1;
            ans[i - 1] = 1/len;
        }
        for (int i = 1; i <= n; i++){
            //注意这个j的起始位置以及结束位置
            for (int j = i; j <= 6 * n; j++){
                //来源于上一行的数字叠加
                for (int k = 1; k <= 6; k++){
                    if (j - k >= 0){
                        state[i][j] += state[i - 1][j - k];
                    }else {
                        break;
                    }
                }
                //最后一行给结果更新
                if (i == n && j >= i){
                    ans[j - i] = state[i][j] / len;
                }
            }
        }
        return ans;
    }
}
