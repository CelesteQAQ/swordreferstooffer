package offer0830;

/**
 * @author: celeste
 * @create: 2020-08-30 02:38
 * @description:
 * 题目：剑指 Offer 52. 两个链表的第一个公共节点
 * 描述：
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 * 在节点 c1 开始相交。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5],
 * skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，
 * 链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；
 * 在 B 中，相交节点前有 3 个节点。
 **/
public class GetIntersectionNode {
    /**
     * 求两个链表的公共第一个节点是可以链表A和链表B同时开始遍历，A遍历结束就从B开始
     * B遍历结束就从A开始，这样相遇就是第一个公共的子节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        //有一个是null都可以返回null
        if (headA == null || headB == null) return null;
        //相遇就是相等的时候
        while (A != B){
            if (A != null){
                A = A.next;
                //A遍历到最后面，换到另一个链表开始
            }else {
                A = headB;
                //不可以添加 A = A.next，因为可能会刚刚好跳过相等的部分，因为开头第一个没有比较到
            }
            if (B != null){
                B = B.next;
                //B也是同样
            }else {
                B = headA;
            }
        }
        return A;
    }
}
