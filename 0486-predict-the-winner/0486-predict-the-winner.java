class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>j) dp[i][j] = -1;
                else if(Math.abs(i-j)<2) dp[i][j] = Math.max(nums[i],nums[j]);
            }
        }
        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                int left = nums[i] + Math.min(dp[i+2][j], dp[i+1][j-1]);
                int right = nums[j] + Math.min(dp[i][j-2], dp[i+1][j-1]);
                dp[i][j] = Math.max(left,right);
            }
        }
        int sum = 0;
        for(int x : nums) sum += x;
        if(dp[0][n-1] >= sum - dp[0][n-1]) return true;
        return false;
    }
}