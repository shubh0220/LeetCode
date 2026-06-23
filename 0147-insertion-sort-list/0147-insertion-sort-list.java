/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode t = head;
        while(t != null){
            ListNode next = t.next;
            ListNode prev = dummy;
            while(prev.next != null && prev.next.val<t.val){
                prev = prev.next;
            }
            t.next = prev.next;
            prev.next = t;
            t = next;
        }
        return dummy.next;
    }
}