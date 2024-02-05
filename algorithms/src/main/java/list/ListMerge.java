package list;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ListMerge {

    public static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, null);
        ListNode p = list1;
        ListNode q = list2;
        ListNode c = dummy;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                c.next = p;
                p = p.next;
            } else {
                c.next = q;
                q = q.next;
            }
        }
        if (p != null) {
            c.next = p;
        }
        if (q != null) {
            c.next = q;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode findLastKNode(ListNode list, int k) {
        if (list == null) {
            return null;
        }
        ListNode p = list;
        ListNode q = p;
        int cnt = 0;
        while (q != null && cnt < k) {
            q = q.next;
            cnt ++;
        }
        while (q != null) {
            q = p.next;
            p = p.next;
        }
        return p;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode x= findLastKNode(head, n+1);
        x.next = x.next.next;
        return dummy.next;

//        ListNode dummy = new ListNode(-1, head);
//        ListNode p = dummy;
//        ListNode q =  head;
//        int cnt = 0;
//        while (q != null && cnt < n) {
//            q = q.next;
//            cnt++;
//        }
//        while (q != null) {
//            q = q.next;
//            p = p.next;
//        }
//        p.next = p.next.next;
//
//        return dummy.next;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


}
