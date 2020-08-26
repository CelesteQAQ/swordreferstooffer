package offer0826;

/**
 * @author: celeste
 * @create: 2020-08-26 15:13
 * @description:
 * 题目：剑指 Offer 47. 礼物的最大价值
 * 描述：在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 **/
public class MaxValue {
    /**
     * 典型的动态规划的题目，就是求到每个位置的最大值是多少
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid){
        int[][] state = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                state[i + 1][j + 1] = Math.max(state[i][j + 1], state[i + 1][j]) + grid[i][j];
            }
        }
        return state[grid.length][grid[0].length];
    }

    /**
     * 只设置一个数组，而不是矩阵
     * 神奇的是只建立一个数组居然比前面耗费的空间还要大
     * leetcode真的神奇
     * @param grid
     * @return
     */
    public int maxValue2(int[][] grid){
        int[] state = new int[grid[0].length + 1];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                state[j + 1] = Math.max(state[j], state[j + 1]) + grid[i][j];
            }
        }
        return state[grid[0].length];
    }
}
