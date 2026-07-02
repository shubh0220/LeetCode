class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int sum = 0;
        for(int i=m-1;i>=0;i--){
            sum += grid[i][n-1];
            dp[i][n-1] = sum;
        }
        sum =0;
        for(int i=n-1;i>=0;i--){
            sum += grid[m-1][i];
            dp[m-1][i] = sum;
        }
        if(m == 1 || n==1) return dp[0][0];
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                int left = grid[i][j] + dp[i+1][j];
                int right = grid[i][j] + dp[i][j+1];
                dp[i][j] = Math.min(left,right);
            }
        }
        return dp[0][0];
    }
}