package offer0820;

import javax.swing.*;

/**
 * @author: celeste
 * @create: 2020-08-20 17:09
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{2, 5, 8}, new int[]{4, 0, 1}};
        SpiralOrder sp = new SpiralOrder();
        sp.spiralOrder_1(matrix);
    }
}
