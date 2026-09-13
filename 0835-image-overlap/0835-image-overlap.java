class Solution {
    int count(int[][] img1,int[][] img2,int dr,int dc){
        int n = img1.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int row = i+dr;
                int col = j+dc;
                if(row>=0 && row<n && col>=0 && col<n){
                    if(img1[i][j] == 1 && img2[row][col] == 1) ans++;
                }
            }
        }
        return ans;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int ans = 0;
        for(int dr=1-n;dr<n;dr++){
            for(int dc=1-n;dc<n;dc++){
                ans = Math.max(ans,count(img1,img2,dr,dc));
            }
        }
        return ans;
    }
}