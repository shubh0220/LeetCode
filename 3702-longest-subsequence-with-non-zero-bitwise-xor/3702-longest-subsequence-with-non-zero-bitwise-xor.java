class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalXor = 0;
        boolean nonZero = false;
        for(int x:nums){
            totalXor ^= x;
            if(x != 0) nonZero = true;
        }
        if(totalXor != 0) return n; 
        if(nonZero) return n-1;
        return 0;   
    }
}