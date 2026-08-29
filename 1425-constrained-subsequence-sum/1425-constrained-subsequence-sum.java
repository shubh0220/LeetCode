class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(0);
        for(int i=1;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst() <i-k) dq.pollFirst();
            int mx = dp[dq.peekFirst()];
            dp[i] = nums[i] + Math.max(0,mx);
            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) dq.pollLast();
            dq.offerLast(i);
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}