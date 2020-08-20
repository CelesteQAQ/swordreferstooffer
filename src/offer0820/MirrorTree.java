package offer0820;

/**
 * @author: celeste
 * @create: 2020-08-20 16:18
 * @description:
 * 题目：剑指 Offer 27. 二叉树的镜像
 * 描述：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 **/
public class MirrorTree {
    /**
     * 从上往下交换左右子树，然后每个左右子树都需要交换
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);
        return root;
    }
}
