class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int freshCnt = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
                else vis[i][j] = 0;
                if(grid[i][j] == 1) freshCnt++;
            }
        }
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        int time = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.time;
            time = Math.max(time,t);
            for(int i=0;i<4;i++){
                int nr = r + dRow[i];
                int nc = c + dCol[i];
                if(nr>=0 && nr < n && nc>=0 && nc<m && vis[nr][nc] == 0 && grid[nr][nc] == 1){
                    q.offer(new Pair(nr,nc,t+1));
                    vis[nr][nc] = 1;
                    cnt++;
                }
            }
        }
        if(freshCnt != cnt) return -1;
        return time;
    }
}