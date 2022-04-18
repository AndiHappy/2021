import util.ListNode;

import java.util.Arrays;
import java.util.List;

public class A {

    /**
     * @param head
     * 1--> 2--> 3
     * 2-->1--->3
     * */
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode next = head.next;
        ListNode nextN = head.next.next;
        next.next=nextN;
        nextN.next=next;
        nextN.next= swapPairs(nextN);
        return nextN;
    }
}
