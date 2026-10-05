class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        int ans = 0;
        int dep = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '(') dep++;
            else{
                dep--;
                if(s.charAt(i-1) == '(') ans += 1 << dep;
            }
        }
        return ans;
    }
}