class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        int c = 0;
        for(int i = n-1;i>0;i--){
            int k = nums[i];
           while(i > 0 && nums[i] == nums[i-1]){i--;}
           if(i != 0) ans += n-i;
        }
        return ans;
    }
}