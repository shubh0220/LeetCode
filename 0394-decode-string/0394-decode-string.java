class Solution {
    int idx = 0;
    String decode(String s){
        StringBuilder ans = new StringBuilder();
        int num = 0;
        while(idx < s.length() && s.charAt(idx) != ']'){
            char ch = s.charAt(idx);
            if(Character.isDigit(ch)){
                num = 0;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    int digit = s.charAt(idx) - '0';
                    num = num*10 + digit;
                    idx++;
                }
                idx++;
                String decoded = decode(s);
                idx++;
                while(num-->0) ans.append(decoded);
            }
            else if(ch >= 'a' && ch <= 'z'){
                ans.append(ch);
                idx++;
            }
            else{
                ans.append(ch);
                idx++;
            }
        }
        return ans.toString();
    }
    public String decodeString(String s) {
        return decode(s);
    }
}