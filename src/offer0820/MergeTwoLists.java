package offer0820;

import offer0818.ListNode;

/**
 * @author: celeste
 * @create: 2020-08-20 15:17
 * @description:
 * 题目：剑指 Offer 25. 合并两个排序的链表
 * 描述：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 **/
public class MergeTwoLists {
    /**
     * 合并两个链表就是要一直比较
     * 然后小的加入更新然后继续比较
     * 最后将剩下的部分加入既可以来
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;
        //注意是l1以及l2都不是null的情况下遍历，如果有一个是null都可以直接添加来
        while (l1 != null && l2 != null){
            // 小于等于加l1
            if (l1.val <= l2.val){
                dummy.next = l1;
                l1 = l1.next;
                dummy = dummy.next;
            }else {
                dummy.next = l2;
                l2 = l2.next;
                dummy = dummy.next;
            }
        }
        // 添加剩余部分
        if (l1 != null){
            dummy.next = l1;
        }
        if (l2 != null){
            dummy.next = l2;
        }
        return merge.next;
    }

    /**
     * 递归方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList_1(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoList_1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList_1(l2.next, l1);
            return l2;
        }
    }
}
