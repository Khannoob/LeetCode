package list;

public class RemoveNthNodeFromEndOfList19 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        RemoveNthNodeFromEndOfList19 rn = new RemoveNthNodeFromEndOfList19();
        rn.removeNthFromEnd(node, 2);
    }
    //快慢双指针,前指针走了N之后,后指针才出发
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode p1 = head, p2 = head;
        ListNode dummy = new ListNode(-1), p = dummy;
        while (p1.next != null) {
            p1 = p1.next;
            cnt++;
            if (cnt >= n) {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        p.next = p2.next;
        return dummy.next;
    }
}
