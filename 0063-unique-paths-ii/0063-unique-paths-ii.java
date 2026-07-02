class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean o = false;
         for(int i = m-1;i >= 0;i--){
            if(obstacleGrid[i][n-1] == 1) o = true;
            if(o) dp[i][n-1] = 0;
            else dp[i][n-1] = 1;
        }
        if(m == 1 && o) return 0;
        o = false;
        for(int i = n-1;i>=0;i--){
            if(obstacleGrid[m-1][i] == 1) o = true;
            if(o) dp[m-1][i] = 0;
            else dp[m-1][i] = 1;
        }
        if(n == 1 && o) return 0;
        for(int i = m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else {int left = dp[i+1][j];
                int right = dp[i][j+1];
                dp[i][j] = left + right;}
            }
        }
        return dp[0][0];
    }
}