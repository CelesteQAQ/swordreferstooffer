package offer0830;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

/**
 * @author: celeste
 * @create: 2020-08-30 17:59
 * @description:
 * 题目：剑指 Offer 54. 二叉搜索树的第k大节点
 * 描述：给定一棵二叉搜索树，请找出其中第k大的节点。
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 **/
public class KthLargest {
    /**
     * 二叉搜索树的中序遍历结果是有序的，这样可以根据前序遍历的结果去找到第k个数字
     * @param root
     * @param k
     * @return
     */
    public int kthLargest1(TreeNode root, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        dfs(root, arrayList);
        return arrayList.get(arrayList.size() - k);
    }

    private void dfs(TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null) return;
        dfs(root.left, arrayList);
        arrayList.add(root.val);
        dfs(root.right, arrayList);
    }

    /**
     * 第二种方法就是直接从最大的开始遍历找到最大的k值就结束返回
     * @param root
     * @param k
     * @return
     */
    int ans = 0, count = 0;
    public int kthLargest2(TreeNode root, int k){
        dfs1(root, k);
        return ans;
    }

    /**
     * 注意是从右边开始遍历，因为求得是最大的k值而不是最小的k值
     * @param root
     * @param k
     */
    private void dfs1(TreeNode root, int k) {
        if (root == null) return;
        dfs1(root.right, k);
        if (++count == k){
            ans = root.val;
            return;
        }
        dfs1(root.left, k);
    }
}
