package list;

public class RemoveDuplicatesFromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode fast = head, slow = head;
        while(fast!=null){
            if(fast.val > slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        //断开重复链接
        slow.next = null;
        //slow是指针,返回的是拉链
        return head;
    }
}
