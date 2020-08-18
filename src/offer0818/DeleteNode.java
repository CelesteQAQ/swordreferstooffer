package offer0818;

import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-18 11:55
 * @description:
 * 题目：剑指 Offer 18. 删除链表的节点
 * 描述：给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 **/
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val){
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode dummy = pre;
        while (pre.next != null){
            if (pre.next.val == val){
                pre.next = pre.next.next;
                return dummy.next;
            }else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
