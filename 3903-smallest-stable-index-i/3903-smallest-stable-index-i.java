class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffixMax = new int[n];
        int[] prefixMin = new int[n];
        suffixMax[0] = nums[0];
        prefixMin[n-1] = nums[n-1]; 
        int sMax = nums[0];
        int pMin = nums[n-1];
        for(int i=1;i<n;i++){
            sMax = Math.max(sMax,nums[i]);
            suffixMax[i] = sMax;
        }
        for(int i=n-2;i>=0;i--){
            pMin = Math.min(pMin,nums[i]);
            prefixMin[i] = pMin;
        }
        for(int i=0;i<n;i++){
            if(suffixMax[i]-prefixMin[i] <= k) return i;
        }
        return -1;
    }
}