class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            int sum = 0;
            int best = Integer.MIN_VALUE;
            for(int j=1;j+i<=n && j<=3;j++){
                sum += stoneValue[i+j-1];
                best = Math.max(best,sum-dp[i+j]);
            }
            dp[i] = best;
        }
        if(dp[0]>0) return "Alice";
        else if(dp[0]<0) return "Bob";
        return "Tie";
    }
}