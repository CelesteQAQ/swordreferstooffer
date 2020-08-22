package offer0823;

import offer0820.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-23 02:15
 * @description:
 * 题目：剑指 Offer 34. 二叉树中和为某一值的路径
 * 描述：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 **/
public class PathSum {
    /**
     * 如何确定是否是22，因为可以由左边给也可以是右边
     * 这个没有之前那个题难，是因为是规定是从根节点到叶节点，所以是必须含有根节点以及叶节点
     * 使用回溯法来找路径
     * @param root
     * @param sum
     * @return
     */
    List<List<Integer>> result = new ArrayList<>();//放置最后的结果
    ArrayList<Integer> cur = new ArrayList<>();//当前遍历到的结果
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        route(root, sum);
        return result;
    }

    private void route(TreeNode root, int sum) {
        if (root == null) return;
        //添加当前的位置的值
        cur.add(root.val);
        //如果是叶子节点就可以将这个结果加入到最后的结果当中
        if (root.left == null && root.right == null && sum == root.val){
            List<Integer> ans = new ArrayList<>(cur);
            result.add(ans);
        }
        //不是叶子节点可以对左右子树开始遍历，但是左右子树只需要凑够sum-root.val的数值就可以了
        route(root.left, sum - root.val);
        route(root.right, sum - root.val);
        // 回溯的是否可以将当前的位置去掉，因为已经遍历过了
        cur.remove(cur.size() - 1);
    }
}
