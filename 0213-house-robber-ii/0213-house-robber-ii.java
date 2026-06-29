class Solution {
    int helper(int[] nums,int s,int e){
        int n = e-s+1;
       int[] dp = new int[n];
       dp[0] = nums[s];
       dp[1] = Math.max(nums[s],nums[s+1]);
       for(int i=2;i<n;i++){
        int p = nums[s+i] + dp[i-2];
        int np = dp[i-1];
        dp[i] = Math.max(p,np); 
       }
       return dp[n-1];
    }
    public int rob(int[] nums) {
       int n = nums.length;
       if(n == 2 || n ==1) return Math.max(nums[n-1],nums[0]);
       return Math.max(helper(nums,0,n-2),helper(nums,1,n-1));
    }
}