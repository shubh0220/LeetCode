class Solution {
    boolean helper(int m,int n,char[][] nums, char[] k,int id){
        if(m<0 || n<0 || m>=nums.length || n>=nums[0].length || nums[m][n] == '#' ||nums[m][n] != k[id]) return false;
        if(id == k.length-1) return true;
        char ch = nums[m][n];
        nums[m][n] = '#';
        boolean p = helper(m+1,n,nums,k,id+1) || helper(m-1,n,nums,k,id+1) || helper(m,n+1,nums,k,id+1) || helper(m,n-1,nums,k,id+1);
        nums[m][n] = ch;
        return p;
    }
    public boolean exist(char[][] board, String word) {
        char[] k = word.toCharArray();
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == k[0] && helper(i,j,board,k,0)) return true;
            }
        }
        return false;
    }
}