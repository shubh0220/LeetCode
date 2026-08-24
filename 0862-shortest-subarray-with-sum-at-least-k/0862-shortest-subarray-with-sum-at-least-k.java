class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] pref = new int[n+1];
        pref[0] = 0;
        int len = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) pref[i+1] = pref[i] + nums[i];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<=n;i++){
            while (!dq.isEmpty() && pref[dq.peekLast()] >= pref[i]) dq.pollLast();
            dq.offerLast(i);
            while(!dq.isEmpty() && (pref[i] - pref[dq.peekFirst()])>=k){
                len = Math.min(i-dq.pollFirst(),len);
            }
        }
        if(len == Integer.MAX_VALUE) return -1;
        return len;
    }
}