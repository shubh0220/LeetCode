class Solution {
    void helper(int id,int[] nums,List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        if (id == nums.length)return;
        for(int i=id;i<nums.length;i++){
            if(i>id && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            helper(i+1,nums,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0,nums,list,ans);
        return ans;
    }
}