class Solution {
    String invert(String s){
        StringBuilder ans = new StringBuilder();
        for(char c : s.toCharArray()){
            int num = c - '0';
            if(num == 1) ans.append('0');
            else ans.append('1');
        }
        return ans.toString();
    }
    String S(int n){
        if(n == 0) return "0";
        String s = S(n-1);
        String rev = new StringBuilder(s).reverse().toString();
        return s + "1" + invert(rev);
    }
    public char findKthBit(int n, int k) {
        String s = S(n);
        return s.charAt(k-1);
    }
}