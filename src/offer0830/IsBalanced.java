package offer0830;

/**
 * @author: celeste
 * @create: 2020-08-30 20:24
 * @description:
 * 题目：剑指 Offer 55 - II. 平衡二叉树
 * 描述：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 **/
public class IsBalanced {
    /**
     * 当前节点平衡的条件：
     * 左子树是平衡的，右子树是平衡的，左子树与右子树的高度差不超过1
     * 需要保留几个信息，一个是高度，每个节点的高度，
     * 全部用递归的时间复杂度太高
     * 为什么一样的代码时间复杂度差距这么大？
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root){
        if (root == null) return true;
        //注意先求深度会耗费大量时间，最好求深度是在判断之后进行
        //如：return isBalanced(root.left) && isBalanced(root.right)
        // && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(leftDepth - rightDepth) <= 1;

    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        //可以省1ms
        if (root.left == null && root.right == null) return 1;
        //或者：return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
