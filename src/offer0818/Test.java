package offer0818;

/**
 * @author: celeste
 * @create: 2020-08-18 13:13
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        ListNode node = new ListNode(-3);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(-99);
        node.next = node1;
        node1.next = node2;
        DeleteNode de = new DeleteNode();
        de.deleteNode(node, -3);
    }
}
