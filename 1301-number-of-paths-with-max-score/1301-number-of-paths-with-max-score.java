class Solution {
    static final int MOD = 1_000_000_007;
    public int[] pathsWithMaxScore(List<String> board) {
        boolean r = false;
        int n = board.size();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board.get(i).charAt(j);
                if (ch == 'X') grid[i][j] = -1;
                else if (ch == 'E' || ch == 'S') grid[i][j] = 0;
                else grid[i][j] = ch - '0';
            }
        }
        int[][] sum = new int[n][n];
        int[][] ways = new int[n][n];
        boolean block = false;
        ways[0][0] = 1;
        int s = 0;
        sum[0][0] = 0;
        for(int i=1;i<n;i++){
            if(grid[0][i] == -1) block = true;
            if(block){
                sum[0][i] = -1;
                ways[0][i] = 0;
                continue;
            }
            s += grid[0][i];
            sum[0][i] = s;
            ways[0][i] = 1;
        }
        s = 0;
        block = false;
        for(int i=1;i<n;i++){
            if(grid[i][0] == -1) block = true;
            if(block){
                sum[i][0] = -1;
                ways[i][0] = 0;
                continue;
            }
            s += grid[i][0];
            sum[i][0] = s;
            ways[i][0] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j] == -1){
                    sum[i][j] = -1;
                    ways[i][j] = 0;
                    continue;
                }
                int f1 = grid[i][j] + sum[i-1][j];
                int f2 = grid[i][j] + sum[i][j-1];
                int f3 = grid[i][j] + sum[i-1][j-1];
                sum[i][j] = Math.max(f1,Math.max(f2,f3));
                int way = 0;
                if (sum[i][j] == f1) way = (way + ways[i-1][j])%MOD;
                if (sum[i][j] == f2) way = (way + ways[i][j-1])% MOD;
                if (sum[i][j] == f3) way = (way + ways[i-1][j-1])% MOD;
                ways[i][j] = way;
            }
        }
        if(ways[n-1][n-1] == 0) return new int[]{0,0};
        return new int[]{sum[n-1][n-1],ways[n-1][n-1]};
    }
}