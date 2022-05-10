package list;

import java.util.PriorityQueue;

public class MergeTwoSortedLists21 {

    public static void main(String[] args) {
        MergeTwoSortedLists21 ms = new MergeTwoSortedLists21();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //虚拟连表头
        //新建链表要建一个锯齿还要一个指针,通过dummy = p 绑定,然后指针不断向前
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //l1和l2像拉链的锯齿,p1p2指针滑动在锯齿上
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;//相互链接的一定是指针
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 == null) {
            p.next = p2;
        }
        if (p2 == null) {
            p.next = p1;
        }
        return dummy.next;
    }


}
