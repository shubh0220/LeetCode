class Solution {
    void helper(int n,List<String> ans,int left,int right,String s){
        if(s.length() == 2*n) {ans.add(s); return;}
        if(left < n) helper(n,ans,left+1,right,s+"(");
        if(right < left) helper(n,ans,left,right+1,s+")");
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,ans,0,0,"");
        return ans;
    }
}