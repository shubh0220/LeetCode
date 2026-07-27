class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        if(n == 0) return s;
        int[] LPS = new int[n];
        int i=1;
        int len = 0;
        LPS[0] = 0;
        while(i<n){
            if(s.charAt(i) == s.charAt(len)) LPS[i++] = ++len;
            else{
                if(len != 0) len = LPS[len-1];
                else LPS[i++] = 0;
            }
        }
        return s.substring(0,LPS[n-1]);
    }
}