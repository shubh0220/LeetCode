class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] sum = new int[n];
        sum[n-1] = piles[n-1];
        for(int i=n-2;i>=0;i--) sum[i] = sum[i+1] + piles[i];
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int m=1;m<=n;m++){
                int total = sum[i];
                int current  = Integer.MAX_VALUE;
                for(int x=1;x<=Math.min(2*m,n-i);x++){
                    current = Math.min(current,dp[i+x][Math.max(x,m)]);     
                }
                dp[i][m] = total-current;
            }
        }
        return dp[0][1];
    }
}