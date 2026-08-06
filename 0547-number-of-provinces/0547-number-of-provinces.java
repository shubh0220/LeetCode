class Solution {
    void dfs(int node,int[][] isConnected,int n,boolean[] vis){
        vis[node] = true;
        for(int i=0;i<n;i++){
            if(isConnected[node][i] == 1 && !vis[i]) dfs(i,isConnected,n,vis);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        dfs(0,isConnected,n,vis);
        int ans = 1;
        for(int i=0;i<n;i++){
            if(!vis[i]){ 
                dfs(i,isConnected,n,vis);
                ans++;
            }
        }
        return ans;
    }
}