class Solution {
    String s;
    int n;
    int[][] memo;
    int[][] costMemo;
    int getCost(int i,int j){
        int len = j-i+1;
        if(costMemo[i][j] != -1) return costMemo[i][j];
        int cost = Integer.MAX_VALUE;
        for(int d=1;d<len;d++){
            if(len%d != 0) continue;
            int c = 0;
            for(int g=0;g<d;g++){
                int l = i+g;
                int r = l + (len/d-1)*d;
                while(l<r){
                    if(s.charAt(l) != s.charAt(r)) c++;
                    l += d;
                    r -= d;
                }
            }
            cost = Math.min(c,cost);
        }
        return costMemo[i][j] = cost;
    }
    int helper(int st,int k){
        if(k == 0){
            if(st == n) return 0;
            return Integer.MAX_VALUE;
        }
        if(st + 2*k>n) return Integer.MAX_VALUE;
        if(memo[st][k] != -1) return memo[st][k];
        int ans = Integer.MAX_VALUE;
        for(int e = st+1;e<n;e++){
            int rem = helper(e+1,k-1);
            if(rem == Integer.MAX_VALUE) continue;
            ans = Math.min(ans,getCost(st,e)+rem);
        }
        return memo[st][k] = ans;
    }
    public int minimumChanges(String s, int k) {
        this.s = s;
        n = s.length();
        memo = new int[n+1][k+1];
        for(int[] x : memo) Arrays.fill(x,-1);
        costMemo = new int[n+1][n+1];
        for(int[] x : costMemo) Arrays.fill(x,-1);
        return helper(0,k);
    }
}