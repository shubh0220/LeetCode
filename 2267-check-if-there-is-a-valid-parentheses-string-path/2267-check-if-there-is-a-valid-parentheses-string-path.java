class Solution {
    boolean[][][] dp;
    boolean[][][] vis;
    boolean helper(int i,int j,char[][] grid,int balance,int m,int n){
        if(i>=m || j>=n) return false;
        if(vis[i][j][balance]) return dp[i][j][balance];
        vis[i][j][balance] = true;
        char ch = grid[i][j];
        if(ch == '(') balance++;
        if(ch == ')') balance--;
        if(balance < 0) return false;
        if(i==m-1 && j == n-1){
            if(balance == 0) return true;
            return false;
        }
        return dp[i][j][balance] =  (helper(i+1,j,grid,balance,m,n) || helper(i,j+1,grid,balance,m,n));
    }
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new boolean[m][n][m+n];
        vis = new boolean[m][n][m+n];
        return helper(0,0,grid,0,m,n);
    }
}