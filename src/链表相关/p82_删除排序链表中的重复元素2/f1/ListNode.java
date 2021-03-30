package 链表相关.p82_删除排序链表中的重复元素2.f1;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //如果是空链表或者一个节点 直接返回
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        //如果当前点与下一个点val相同 进行循环删除 直到跳到不同
        if (head.val == next.val){
           //循环让下面的相同节点全跳过
            while (next.val==next.next.val){
                next = next.next;
            }
            //当下1节点 和下2节点不同的时候 head直接变为下2节点
            head = next.next;
        }


        return null;
    }
}

class Test {

}
