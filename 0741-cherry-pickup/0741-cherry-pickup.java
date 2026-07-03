class Solution {
    static final int NEG = -1000000000;
    int helper(int r1,int c1,int r2,int[][] grid,int[][][] dp){
        int c2 = r1 + c1 - r2;
        int n = grid.length;
        if(r1 >= n || r2>= n || c1 >= n || c2 >=n || grid[r1][c1] == -1 || grid[r2][c2] == -1) return Integer.MIN_VALUE;
        if(r1 == n-1 && c1 == n-1) return grid[r1][c1];
        int c = 0;
        if(dp[r1][c1][r2] != NEG) return dp[r1][c1][r2];
        c += grid[r1][c1];
        if(r1 != r2 || c1 != c2) c += grid[r2][c2];
        int f1 = helper(r1+1,c1,r2+1,grid,dp);
        int f2 = helper(r1+1,c1,r2,grid,dp);
        int f3 = helper(r1,c1+1,r2,grid,dp);
        int f4 = helper(r1,c1+1,r2+1,grid,dp);
        c += Math.max(Math.max(f1,f2),Math.max(f3,f4));
        dp[r1][c1][r2] = c;
        return c;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for (int[][] a : dp)
                for (int[] c : a)
                    Arrays.fill(c, NEG);
        return Math.max(0,helper(0,0,0,grid,dp));
    }
}