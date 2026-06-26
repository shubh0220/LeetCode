class Solution {
    void helper(int id,int sum,List<List<Integer>> ans,int target,int[] nums,List<Integer> list){
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i =id;i<nums.length;i++){
            if(i>id && nums[i] == nums[i-1]) continue;
            if(sum+nums[i] > target) break;
            list.add(nums[i]);
            helper(i+1,sum+nums[i],ans,target,nums,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0,0,ans,target,candidates,list);
        return ans;
    }
}