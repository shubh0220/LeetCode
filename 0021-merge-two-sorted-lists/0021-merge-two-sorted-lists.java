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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }
        ListNode l = list1;
        ListNode r = list2;
        while(l != null && r != null){
            if(l.val <= r.val){
                while(l.next != null && l.next.val <= r.val){
                l = l.next;
                }
                ListNode t = l;
                l = l.next;
                t.next = r;
            }
            else{
                while(r.next != null && r.next.val <= l.val){
                r = r.next;
                }
                ListNode t1 = r;
                r = r.next;
                t1.next = l;
                }
        }
        if(list1.val <= list2.val){
            return list1;
        }
        else{
            return list2;
        }
    }
}