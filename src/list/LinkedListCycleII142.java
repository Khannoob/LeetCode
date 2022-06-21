package list;

public class LinkedListCycleII142 {
    public ListNode detectCycle(ListNode head) {
        //用快慢双指针判断
        //充值慢指针在头,再次相遇为环起点
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) break;
        }
        if(fast==null || fast.next == null){
            return null;
        }
        slow = head;
        //正常速度
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
