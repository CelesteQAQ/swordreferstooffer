package offer0831;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-31 00:41
 * @description:
 * 题目：剑指 Offer 57 - II. 和为s的连续正数序列
 * 描述：输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 **/
public class FindContinuousSequence {
    /**
     * 左右指针法：
     * 一直添加右指针扩张，判断和是否为目标值，
     * 如果超过目标值就左指针收缩
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target){
        List<int[]> list = new ArrayList<>();
        int l = 1, r = 1, sum = 0;
        //边界是target的一半加一
        while (r <= target / 2 + 1){
            sum += r;
            //超过目标值，左指针收缩
            while (sum > target){
                sum -= l;
                l++;
            }
            //刚刚好为目标值
            if (sum == target){
                //记下当前的数组
                int[] temp = new int[r - l + 1];
                for (int i = 0; i < r - l + 1; i++){
                    temp[i] = l + i;
                }
                list.add(temp);
             }
            r++;
        }
        //返回值需要是数组，所以需要将list复制成数组
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 暴力法试一下
     * 从1开始试着加，加到相等或者是大于就停止，等于就添加进数组，不等于就从2开始试
     * @param target
     * @return
     */
    public int[][] findContinuousSequence2(int target){
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < target / 2 + 1; i++){
            int sum = 0;
            for (int j = i; ; j++){
                sum += j;
                //大于就跳出，下一个i开始
                if (sum > target){
                    break;
                    //刚刚好等于就添加
                }else if (sum == target){
                    int[] temp = new int[j - i + 1];
                    for (int k = 0; k < j - i + 1; k++){
                        temp[k] = i + k;
                    }
                    list.add(temp);
                    break;
                }
            }
        }
        //处理返回值问题
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 从数组长度开始区分，
     * 长度为2：就是从（target - 1）/ 2开始 9： 45； 15：7 8
     * 长度为3：就是从（target - 3）/ 3开始 9：234； 15：456
     * 长度为4：就是从（target - 4）/ 4开始 9：没有。 15：没有
     * 。。。。
     * @param target
     * @return
     */
    public int[][] findContinuousSequence3(int target){
        List<int[]> list = new ArrayList<>();
        int minus = 1;
        //从长度为2的数组开始，边界是开始位置必须是大于等于1
        for(int i = 2; (target - minus) / i >= 1; i++){
            //开始的位置是整数存在就添加，不存在就不添加
            if ((target - minus) % i == 0){
                int[] temp = new int[i];
                for (int j = 0; j < i; j++){
                    temp[j] = (target - minus) / i + j;
                }
                list.add(temp);
            }
            //调整这个数组中与第一个值的差距
            minus += i;
        }
        int[][] res = new int[list.size()][];
        int n = res.length;
        for (int i = 0; i < n; i++){
            res[i] = list.get(n - 1 - i);
        }
        return res;
    }
}
