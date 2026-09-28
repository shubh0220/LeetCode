class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && grid[i][j] == 1){
                    q.offer(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            vis[row][col] = true;
            for(int k=0;k<4;k++){
                int newRow = row+dr[k];
                int newCol = col+dc[k];
                if(newRow>=0 && newCol<n && newCol>=0 && newRow<m && grid[newRow][newCol] == 1 && !vis[newRow][newCol]){
                    vis[newRow][newCol] = true;
                    q.offer(new int[]{newRow,newCol});
                }
            }
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !vis[i][j]) ans++;
            }
        }
        return ans;
    }
}