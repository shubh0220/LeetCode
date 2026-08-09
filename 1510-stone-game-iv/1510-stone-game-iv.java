class Solution {
    public boolean winnerSquareGame(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int j=1;j<=n;j++){
            for(int i=1;i*i<=j;i++){
            if(dp[j-i*i] == 0) dp[j] =  1;
            }
        }
        int k = dp[n];
        if(k == 1) return true;
        return false;
    }
}