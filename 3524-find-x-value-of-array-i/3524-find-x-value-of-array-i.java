class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        int n = nums.length;
        long[][] dp = new long[n][k];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],0);
        for(int i=0;i<k;i++){
            if(nums[0]%k == i) dp[0][i] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<k;j++){
                int rem = (int)((long)j*(nums[i]%k))%k;
                dp[i][rem] += dp[i-1][j];
            }
            dp[i][nums[i]%k]++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                ans[j] += dp[i][j];
            }
        }
        return ans;
    }
}