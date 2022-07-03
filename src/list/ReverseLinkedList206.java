package list;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        //搞清楚reverse函数的意义 把链表倒转
        //base case
        if(head==null || head.next==null) return head;
        ListNode last = reverseList(head.next);//把head之后倒转了
        head.next.next = head;//把第二个的next置为head
        head.next = null;//把head自己的next置为null
        //现在的头结点是last
        return last;
    }


}
