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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDis = Integer.MAX_VALUE;
        if(head.next.next == null) return new int[]{-1,-1};
        ListNode prev = head;
        ListNode curr = head.next;
        int firstCritical = -1;
        int prevCritical = -1;
        int idx = 1;
        while(curr.next != null){
            ListNode next1 = curr.next;
            if(((curr.val>prev.val) && (curr.val>next1.val)) || (curr.val<prev.val) && (curr.val<next1.val)){
                if(firstCritical == -1) firstCritical = idx;
                if(prevCritical != -1) minDis = Math.min(idx-prevCritical,minDis); 
                prevCritical = idx;
            }
            idx++;
            prev = curr;
            curr = curr.next;
        }
        if(firstCritical == -1 || firstCritical == prevCritical) return new int[]{-1,-1};
        int maxDis = prevCritical - firstCritical;
        return new int[]{minDis,maxDis};
    }
}