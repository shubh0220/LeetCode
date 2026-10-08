class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int a = 0;
        for (int i =0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(a>0) sb.append(ch);
                a++;
            }
            else{
                a--;
                if(a>0) sb.append(ch);
            }
        }
        return sb.toString();
    }
}