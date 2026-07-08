class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = (int)1e9;
        int[][] dp = new int[n][amount+1];
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) dp[0][j] = j/coins[0];
            else dp[0][j] = INF;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int not = dp[i-1][j];
                int take = INF;
                if(coins[i] <= j){
                    take = dp[i][j-coins[i]]+1;
                }
                dp[i][j] = Math.min(not,take);
            }
        }
        return dp[n-1][amount] >= INF ? -1 : dp[n-1][amount];
    }
}