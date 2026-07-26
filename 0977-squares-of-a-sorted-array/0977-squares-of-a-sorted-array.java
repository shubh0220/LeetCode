class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int i = n-1;
        int[] ans = new int[n];
        while(l<=r){
            int r2 = nums[r]*nums[r];
            int l2 = nums[l]*nums[l];
            if(r2 >= l2){
                ans[i] = r2;
                r--;
                i--;
            }
            else{
                ans[i] = l2;
                l++;
                i--;
            }
        }
        return ans;
    }
}