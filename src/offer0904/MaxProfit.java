package offer0904;

/**
 * @author: celeste
 * @create: 2020-09-04 02:52
 * @description:
 * 题目：剑指 Offer 63. 股票的最大利润
 * 描述：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 **/
public class MaxProfit {
    /**
     * 找到之前出现的最小的价钱以及更新当前的最大利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices){
            if (price > minPrice){
                maxPro = Math.max(maxPro, price - minPrice);
            }else {
                minPrice = price;
            }
        }
        return maxPro;
    }
}
