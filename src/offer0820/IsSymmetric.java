package offer0820;

/**
 * @author: celeste
 * @create: 2020-08-20 16:32
 * @description:
 * 题目：剑指 Offer 28. 对称的二叉树
 * 描述：请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 **/
public class IsSymmetric {
    /**
     * 如果跟镜像一样就是对称的，那就求出镜像对比是否一样
     * 不可以的原因是因为返回的还是root，怎样对比都是true的
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root){
        MirrorTree mi = new MirrorTree();
        TreeNode mirror = mi.mirrorTree(root);
        return root == mirror;

    }

    /**
     * 递归方法就是需要找到如何循环比较好
     * @param root
     * @return
     */
    public boolean isSymmetric_1(TreeNode root){
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    /**
     * 对比左右是否对称
     * @param left
     * @param right
     * @return
     */
    private boolean helper(TreeNode left, TreeNode right) {
        // 左右都是null，肯定是对称的
        if (left == null && right == null) return true;
        // 有一边是null，一边不是null，则肯定不对称
        if (left == null || right == null) return false;
        //对称必须是值相等并且左子树与另一个树的右子树，右子树与另一个子树的左子树是对称的
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }
}
