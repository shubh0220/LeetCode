class Solution {
    public int maxDepth(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') left++;
            else if(ch == ')') right++;
            ans = Math.max(ans,left-right);
        }
        return ans;
    }
}