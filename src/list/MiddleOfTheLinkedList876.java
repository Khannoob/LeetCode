package list;

public class MiddleOfTheLinkedList876 {
    //快慢指针,快指针前进2,慢指针前进1
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        int cnt = 0;
        while (fast.next != null) {
            fast = fast.next;
            if (cnt++ % 2 == 0)
                slow = slow.next;
        }
        return slow;
    }
}
