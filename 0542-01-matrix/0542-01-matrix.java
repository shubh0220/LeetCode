class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(vis[i],false);
            Arrays.fill(ans[i],0);
        }
        Queue<int[]> q = new LinkedList<>();
        int[] dRow = new int[]{-1,0,1,0};
        int[] dCol = new int[]{0,1,0,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){ 
                    q.offer(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] nums = q.poll();
            ans[nums[0]][nums[1]] = nums[2];
            for(int i=0;i<4;i++){
                int newRow = nums[0] + dRow[i];
                int newCol = nums[1] + dCol[i];
                if(newRow<0 || newRow>=m || newCol<0 || newCol>=n || vis[newRow][newCol]) continue;
                vis[newRow][newCol] = true;
                q.offer(new int[]{newRow,newCol,nums[2]+1});
            }
        }
        return ans;
    }
}