package list;

public class IntersectionOfTwoLinkedLists160 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4,new ListNode(1,new ListNode(8,new ListNode(4,new ListNode(5)))));
        ListNode node2 = new ListNode(5,new ListNode(6,new ListNode(1,new ListNode
                (8,new ListNode(4,new ListNode(5))))));
        IntersectionOfTwoLinkedLists160 io = new IntersectionOfTwoLinkedLists160();
        io.getIntersectionNode(node1, node2);
    }
    //两个指针同时走，A走完走B，B走完走A，就能到达两个交汇点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
// p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }
}
