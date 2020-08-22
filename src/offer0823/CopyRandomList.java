package offer0823;

/**
 * @author: celeste
 * @create: 2020-08-23 02:59
 * @description:
 * 题目：剑指 Offer 35. 复杂链表的复制
 * 描述：请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 **/
public class CopyRandomList {
    /**
     * 这个复制其实很经典，就是需要在每个节点之后复制一个，然后再调整位置？
     * 然后再解决复制下一个节点的位置，
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        //复制一个节点在每个节点后面
        while (cur != null){
            Node next = cur.next;
            Node temp = new Node(cur.val);
            temp.next = next;
            cur.next = temp;
            cur = cur.next.next;
        }
        //复制每个节点的random节点
        cur = head;
        while (cur != null && cur.next != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node copyNode = cur.next;
        //每一个节点每一个节点断开，分成2个链表
        while (cur != null && cur.next != null){
            Node temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
        }
        return copyNode;
    }
}
