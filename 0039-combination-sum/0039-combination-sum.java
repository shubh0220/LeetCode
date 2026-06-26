class Solution {
    void helper(int id,int sum,List<List<Integer>> ans,int target,int[] nums,List<Integer> list){
        if(id == nums.length || sum > target){
            return;
        }
        if(sum == target) {ans.add(new ArrayList<>(list)); return;}
        list.add(nums[id]);
        helper(id,sum+nums[id],ans,target,nums,list);
        list.remove(list.size() - 1);
        helper(id+1,sum,ans,target,nums,list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0,0,ans,target,candidates,list);
        return ans;
    }
}