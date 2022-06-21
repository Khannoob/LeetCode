package list;

public class PartitionLis86t {
    public static void main(String[] args) {
        PartitionLis86t pl = new PartitionLis86t();

    }
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            }else {
                p2.next = p;
                p2 = p2.next;
            }
//            p = p.next;
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
