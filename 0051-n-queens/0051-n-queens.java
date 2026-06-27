class Solution {
    boolean valid(int c,int r,char[][] board){
        for(int i=0;i<r;i++){
            if(board[i][c] == 'Q') return false;
        }
        for(int i = r-1,j = c-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q') return false;
        }
        for(int i=r-1,j=c+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    List<String> convert(char[][] board){
        List<String> list = new ArrayList<>();
        for(char[] x : board){
            list.add(new String(x));
        }
        return list;
    }
    void helper(int r,char[][] board,List<List<String>> ans){
        if(r == board.length){
            ans.add(convert(board));
            return;
        }
        for(int c =0;c<board.length;c++){
            if(valid(c,r,board)){
                board[r][c] = 'Q';
                helper(r+1,board,ans);
                board[r][c] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] x : board){
            Arrays.fill(x,'.');
        }
        List<List<String>> ans = new ArrayList<>();
        helper(0,board,ans);
        return ans;
    }
}