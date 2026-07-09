class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x : nums) sum += x;
        if (sum - target < 0 || (sum - target) % 2 != 0) return 0;
        int n = nums.length;
        int d = (sum - target)/2;
        int[] prev  = new int[d+1];
        prev[0] = 1;
        if(nums[0] == 0) prev[0] = 2;
        else if(nums[0] <= d) prev[nums[0]] = 1;
        for(int i=1;i<n;i++){
            int[] curr = new int[d+1];
            curr[0] = 1;
            for(int j=0;j<=d;j++){
                int not = prev[j];
                int take = 0;
                if(nums[i] <= j) take = prev[j-nums[i]];
                curr[j] = not + take;
            }
            prev = curr;
        }
        return prev[d];
    }
}