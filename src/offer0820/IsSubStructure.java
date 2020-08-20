package offer0820;

/**
 * @author: celeste
 * @create: 2020-08-20 15:33
 * @description:
 * 题目：剑指 Offer 26. 树的子结构
 * 描述：输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 例如:
 * 给定的树 A:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 **/
public class IsSubStructure {
    /**
     * 如何判断是否是一个子结构？
     * 首先先找到B的根节点出现的位置
     * 然后根据B的根节点遍历，是否一致，一致就是子结构
     * 不是就返回false
     * 对于树的题最好先考虑递归，根节点，左子树，右子树
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // null 不是任何子结构
        if (A == null || B == null) return false;
        //dfs是遍历是否为B的，然后左右还需要检查一遍
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * dfs是遍历检查是否是B
     * @param A
     * @param B
     * @return
     */
    private boolean dfs(TreeNode A, TreeNode B) {
        //B可以检查结束，但是A为null就会导致缺少，因为B不是null
        if (B == null) return true;
        if (A == null) return false;
        //左右再继续循环检查
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
