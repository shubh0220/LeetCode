class Solution {
    public int minInsertions(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '(') st.push(i);
            else{
                if(i+1 < n && s.charAt(i+1) == ')')i++;
                else ans++;
                if(st.isEmpty()) ans ++;
                else st.pop();
            }
        }
        int extra = st.size()*2;
        return ans + extra;
    }
}