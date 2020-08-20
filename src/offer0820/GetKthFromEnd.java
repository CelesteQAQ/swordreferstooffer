package offer0820;

import offer0818.ListNode;

/**
 * @author: celeste
 * @create: 2020-08-20 14:50
 * @description:
 * 题目：剑指 Offer 22. 链表中倒数第k个节点
 * 描述：输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个节点是值为4的节点。
 **/
public class GetKthFromEnd {
    /**
     * 找到倒数第k个
     * 典型的快慢指针问题
     * 快指针先走，然后过了k个之后慢指针开始走
     * 快指针指到终点时，慢指针就是求的指针
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        //首先先遍历完k个后快慢指针再一起遍历
        for (int i = 0; i < k; i++){
            fast = fast.next;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
