class Solution {
    void helper(int idx,int[] nums,List<List<Integer>> ans){
        if(idx == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int x : nums) list.add(x);
            ans.add(list);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(idx,i,nums);
            helper(idx+1,nums,ans);
            swap(idx,i,nums);
        }
    }
    void swap(int i,int j,int[] nums){
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,nums,ans);
        return ans;
    }
}