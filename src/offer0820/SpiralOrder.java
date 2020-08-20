package offer0820;

/**
 * @author: celeste
 * @create: 2020-08-20 16:48
 * @description:
 * 题目：剑指 Offer 29. 顺时针打印矩阵
 * 描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 **/
public class SpiralOrder {
    /**
     * 这个有问题，应该考虑是有4个边界上下左右
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        int x_len = matrix.length;
        if (x_len == 0) return null;
        int y_len = matrix[0].length;
        int[] result = new int[x_len * y_len];
        int r = 0;
        for (int k = 0; k <= x_len / 2; k++){
            int i = k;
            int j = k;
            while (j < y_len - k){
                result[r++] = matrix[i][j++];
            }
            j--;
            i++;
            while (i < x_len - k){
                result[r++] = matrix[i++][j];
            }
            i--;
            j--;
            while (j >= k){
                result[r++] = matrix[i][j--];
            }
            j++;
            i--;
            while (i > k){
                result[r++] = matrix[i--][j];
            }
            i++;
        }
        return result;
    }

    /**
     * 考虑有上下左右四个边界
     * @param matrix
     * @return
     */
    public int[] spiralOrder_1(int[][] matrix){
        int x_len = matrix.length;
        if (x_len == 0) return null;
        int y_len = matrix[0].length;
        int[] result = new int[x_len * y_len];
        int l = 0, r = y_len - 1, up = 0, bo = x_len - 1;
        int count = 0;
        while (up < bo && l < r){
            //上
            for (int j = l; j < r; j++){
                result[count++] = matrix[up][j];
            }
            up++;
            //右
            for (int i = up; i < bo; i++){
                result[count++] = matrix[i][r - 1];
            }
            r--;
            //下，还需要判断一次上与下是否已经重合
            if (up < bo){
                for (int j = r - 1; j >= l; j--){
                    result[count++] = matrix[bo - 1][j];
                }
                bo--;
            }
            //左，同理需要再判断一次左与右是否已经重合
            if (l < r){
                for (int i = bo - 1; i >= up; i--){
                    result[count++] = matrix[i][l];
                }
                l++;
            }
        }
        return result;
    }

}
