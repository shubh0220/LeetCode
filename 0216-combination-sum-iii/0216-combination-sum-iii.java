class Solution {
    void helper(int i,int k,int n,List<List<Integer>> ans,List<Integer> list){
        if(n < 0) return;
        if(k<0) return;
        if(k == 0){
            if(n == 0) ans.add(new ArrayList<>(list));
            return;
        }
        if(i>9) return;
        list.add(i);
        helper(i+1,k-1,n-i,ans,list);
        list.remove(list.size() -1);
        helper(i+1,k,n,ans,list);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(1,k,n,ans,list);
        return ans;
    }
}