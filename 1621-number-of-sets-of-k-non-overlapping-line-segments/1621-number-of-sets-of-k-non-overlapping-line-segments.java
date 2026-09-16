class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n+1][k+1];
        for(int i=0;i<=n;i++) dp[i][0] = 1;
        for(int i=0;i<=k;i++) dp[n][i] = 0;
        for(int j=1;j<=k;j++){
            int[] suffix = new int[n+1];
            for(int x=n-1;x>=0;x--) suffix[x] = (int) ((suffix[x+1]+dp[x][j-1]) % MOD);
            for(int i=n-1;i>=0;i--){
                int skip = dp[i+1][j];
                int take = suffix[i+1];
                dp[i][j] = (skip+take)%MOD;
            }
        }
        return dp[0][k];
    }
}