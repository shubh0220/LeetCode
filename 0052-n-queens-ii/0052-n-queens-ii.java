class Solution {
    boolean valid(int r,int c,char[][] board){
        for(int i =0;i<board.length;i++){
            if(board[i][c] == 'Q') return false;
        }
        for(int i =r-1,j=c-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q') return false;
        }
        for(int i=r-1,j=c+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    int helper(int r,char[][] board){
        if(r == board.length) return 1;
        int ans = 0;
        for(int c =0;c<board.length;c++){
            if(valid(r,c,board)){
                board[r][c] = 'Q';
                ans += helper(r+1,board);
                board[r][c] = '.';
            }
        }
        return ans;
    }
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] x : board){
            Arrays.fill(x,'.');
        }
        return helper(0,board);
    }
}