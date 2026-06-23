class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while(h>=l){
            int m = (l+h)/2;
            if(nums[m]== target){
                return m;
            }
            if(nums[l]<=nums[m]){
                if(nums[l] <= target && nums[m]>target){
                    h = m-1;
                }
                else{
                    l = m+1;
                }
            }
            else if(nums[h]>=nums[m]){
                if(nums[m] < target && nums[h]>=target){
                    l = m+1;
                }
                else{
                    h = m-1;
                }
            }
        }
        return -1;
    }
}