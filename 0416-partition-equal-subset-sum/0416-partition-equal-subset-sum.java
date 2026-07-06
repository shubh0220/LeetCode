class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums) sum += x;
        if(sum %2 != 0) return false;
        int target = sum/2;
        boolean[] prev = new boolean[target+1];
        if(nums[0] <= target) prev[nums[0]] = true;
        prev[0] = true;
        for(int i=1;i<n;i++){
            boolean[] curr =  new boolean[target+1];
            curr[0] = true;
            for(int j=1;j<=target;j++){
                boolean not = prev[j];
                boolean take = false;
                if(nums[i] <= j) take = prev[j-nums[i]];
                curr[j] = not || take;
            }
            prev = curr;
        }
        return prev[target];
    }
}