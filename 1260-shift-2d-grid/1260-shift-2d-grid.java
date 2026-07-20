class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k %= (m*n);
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int row = i;
                int col = j+k;
                if(col >= n){
                    row += col/n;
                    if(row >= m) row %= m;
                    col %= n;
                }
                ans[row][col] = grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(ans[i][j]);
            }
            res.add(row);
        }
        return res;
    }
}