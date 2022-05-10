package list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        ListNode dummy = new ListNode(-1), p = dummy;
        //用最大堆存链表头,每次就能取出最小数
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null)
                minHeap.add(head);
        }
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (node.next != null) {
                minHeap.add(node.next);
            }
            p.next = node;
            p = p.next;
        }
        return dummy.next;
    }
}
