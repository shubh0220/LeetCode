class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '(') st.push(0);
            else{
                int x = st.pop();
                if(x ==0) x = 1;
                else x *=2;
                st.push(st.pop()+x);
            }
        }
        return st.pop();
    }
}