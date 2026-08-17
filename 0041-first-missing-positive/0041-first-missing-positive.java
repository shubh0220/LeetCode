class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i=0;
        while(i<n){
            int idx = nums[i]-1;
            if(nums[i]<1 || idx>=n || nums[idx] == nums[i]) i++;
            else{
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
            }
        }
        for(i=0;i<n;i++){
            if(nums[i] != i+1) return i+1;
        }
        return nums[n-1]+1;
    }
}