class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] sum = new int[n+1];
        sum[0] = 0;
        for(int i=1;i<=n;i++){
            sum[i] = sum[i-1] + stoneValue[i-1];
        }
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) dp[i][j] = 0;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(i==j) continue;
                int total= sum[j+1] - sum[i];
        int result= 0;
        for(int m=i;m<j;m++){
            int sum1 = sum[m+1]-sum[i];
            int sum2 = total - sum1;
            int k=0;
            if(sum1<sum2) k = sum1 + dp[i][m];
            else if (sum2<sum1) k = sum2 +  dp[m+1][j];
            else k= sum1 +  Math.max(dp[i][m],dp[m+1][j]);
            result = Math.max(result,k);
            
        }
        dp[i][j] = result;
            }
        }
      return dp[0][n-1];

    }
}