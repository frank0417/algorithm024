public class MergeTwoLists {

    /*
     * 题 目：合并两个有序链表
     * 链 接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
     * 描 述：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        dummy.next = l1;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur = l1;
                l1 = l1.next;
                continue;
            } else {
                cur.next=l2;
                l2=l2.next;
                cur=cur.next;
                cur.next=l1;
            }
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}


