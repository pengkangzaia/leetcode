package myanswer.linkedlist.easy;

/**
 * 翻转链表
 */
public class No206 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode ans = reverseList1(node1);
        while (ans!=null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode reverseList(ListNode node1) {

        ListNode curr = node1; //指向当前节点
        ListNode next = null; //指向curr当前节点的下一节点
        ListNode reverseNodeHead = new ListNode(-2);


        while (curr!=null){
            next = curr.next;
            curr.next = reverseNodeHead.next;
            reverseNodeHead.next = curr;
            curr = next;
        }

        return reverseNodeHead.next;
    }

    // 递归法
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 设返回的节点为头节点，这样就可以一直保留头节点的引用
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        // 不能返回head，head反转之后是链表的最后一个节点
        return p;
    }


}
