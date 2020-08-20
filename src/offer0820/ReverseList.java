package offer0820;

import offer0818.ListNode;

/**
 * @author: celeste
 * @create: 2020-08-20 15:06
 * @description:
 * 题目：剑指 Offer 24. 反转链表
 * 描述：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 **/
public class ReverseList {
    /**
     * 反转链表首先考虑递归，从前面开始分为next，pre，以及cur节点
     * cur-->next 改为pre，cur改为next
     * 直到next为null结束
     * @param head
     * @return
     */
    public ListNode reverseList (ListNode head){
        if (head == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null){
            //注意交换的顺序
            cur.next = pre;
            //记得把pre也要更新
            pre = cur;
            //更新cur以及next
            cur = next;
            next = cur.next;
        }
        cur.next = pre;
        return cur;
    }

}
