class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int max = Integer.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int r=0;r<n;r++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[r]) dq.pollLast();
            dq.offerLast(r);
            if(dq.peekFirst() < r-k+1) dq.pollFirst();
            if(r >= k-1) ans[r-k+1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}