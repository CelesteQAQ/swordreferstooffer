package offer0822;

/**
 * @author: celeste
 * @create: 2020-08-22 01:39
 * @description:
 * 题目：剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 **/
public class VerifyPostorder {
    /**
     * 二叉搜索树的中序遍历的结果是有序的，但是后序有什么特点？
     * 后序遍历：先左右后根
     * 就是从后面开始建立一个树？
     * 划分区域来判断是否是后序，反正出现的大于最后一个数字的位置往后都是右子树，前面都是左子树
     * 右子树全部都大于根，左子树全部都小于根
     * 循环
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        return post(postorder, 0, n - 1);
    }
    /**
     * 划定的区域判断
     * @param postorder
     * @param start 开始位置
     * @param end 结束位置
     * @return 返回左右子树是否也符合
     */
    private boolean post(int[] postorder, int start, int end) {
        if (start >= end) return true;
        int mid = end;
        // 找到大于最后一个数字的位置
        for (int i = start; i < end; i++){
            if (postorder[i] > postorder[end]) {
                mid = i;
                break;
            }
        }
        // 如果后面存在小于最后一个数字的就返回false
        for (int i = mid; i < end; i++){
            if (postorder[i] < postorder[end]) return false;
        }
        //最后就是需要左右子树也是符合条件的
        return post(postorder, start, mid - 1) && post(postorder, mid, end - 1);
    }
}
