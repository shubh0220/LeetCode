class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0){
            return 0;
        }
        int a = 1;
        int b = 1;
        for(int i=0;i<nums.length - 1;i++){
            if(nums[i+1] == nums[i] +1){
                a++;
                b = Math.max(a,b);
            }
            else if(nums[i+1] == nums[i]) {
                continue;
            }
            else{
                a = 1;
            }
        }
        return b;
    }
}