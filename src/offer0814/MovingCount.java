package offer0814;

/**
 * @author: celeste
 * @create: 2020-08-14 17:16
 * @description:
 * 题目：剑指 Offer 13. 机器人的运动范围
 * 描述：地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 **/
public class MovingCount {
    /**
     * 跟上一道题一样是有限制的，这个是当前位置需要分解成i1 + i2 + j1 + j2
     * 注意是从【0，0】开始移动，不是位置满足条件就一定可以到达
     * 可以将可以访问到的改成true，然后加入
     */
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int movingCount(int m, int n, int k) {
        int result = 0;
        if (m >= 1 && n >= 1 && k >= 0){
            result++;
        }
        boolean[][] state = new boolean[m][n];
        state[0][0] = true;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (state[i][j]){
                    for (int k1 = 0; k1 < 4; k1++){
                        int newX = i + direction[k1][0];//更新位置
                        int newY = j + direction[k1][1];
                        if (newX >= 0 && newX < m && newY >= 0 && newY < n && !state[newX][newY]){
                            int i1 = newX / 10;
                            int i2 = newX % 10;
                            int j1 = newY / 10;
                            int j2 = newY % 10;
                            if (i1 + i2 + j1 + j2 <= k){
                                state[newX][newY] = true;
                                result++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 还有一种使用dfs方法，就是返回上下左右的和，跟我的想法一样使用一个矩阵来将访问过的位置设为true
     */
    public int movingCount_1(int m, int n, int k){
        boolean[][] state = new boolean[m][n];
        return dfs(0, 0, m, n, k, state);
    }

    /**
     *
     * @param i 遍历到下一个横坐标
     * @param j 遍历到下一个纵坐标
     * @param m
     * @param n
     * @param k
     * @param state 遍历过的位置置为true，没有到过的地方是false
     * @return
     */
    private int dfs(int i, int j, int m, int n,int k, boolean[][] state) {
        if (i < 0 || i >= m || j < 0 || j >= n || state[i][j]//这是不会增加1的情况，已经访问过不会添加
                || i / 10 + i % 10 + j / 10 + j % 10 > k){//超过k也不会访问，访问跟添加1是在同一个位置处理
            return 0;
        }
        state[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, state) + dfs(i - 1, j, m, n, k, state)
                + dfs(i, j + 1, m, n, k, state) + dfs(i, j - 1, m, n, k, state);
        //注意可以直接返回右边以及下面的，因为之前已经将上面和左边的元素遍历过来，可以更加省时间
    }

}
