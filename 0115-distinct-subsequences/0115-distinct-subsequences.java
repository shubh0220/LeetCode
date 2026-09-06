class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m>n) return 0;
        if(m==n){
            if(s.equals(t)) return 1;
            return 0;
        }
        int[][] dp = new int[n][m];
        char ch = t.charAt(m-1);
        int cnt = 0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == ch) cnt++;
            dp[i][m-1] = cnt;
        }
        if(s.charAt(n-1) == ch) dp[n-1][m-1] = 1;
        for(int i=0;i<m-1;i++) dp[n-1][i] = 0;
        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                if(s.charAt(i) == t.charAt(j)) dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                else dp[i][j] = dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}