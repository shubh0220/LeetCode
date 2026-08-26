class Solution {
    boolean helper(String s,int l,int r,int low,int high){
        for (int i = 0; i <= r - l; i++) {
            char a = s.charAt(l + i);
            char b = s.charAt(low + i);
            if (a < b) return true;
            if (a > b) return false;
        }
        return false;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int l = 0;
        int cnt1 = 0;
        int len = Integer.MAX_VALUE;
        int low = 0;
        int high = 0;
        for(int r=0;r<n;r++){
            char ch = s.charAt(r);
            if(ch == '1') cnt1++;
            while(cnt1 > k){
                char c = s.charAt(l);
                if(c == '1') cnt1--;
                l++;
            }
            if(cnt1 == k){
                while (s.charAt(l) == '0') l++;
                if(r-l+1 < len){
                    len = r-l+1;
                    low = l;
                    high = r;
                }
                else if(r-l+1 == len){
                    if(helper(s,l,r,low,high)){
                        len = r-l+1;
                        low = l;
                        high = r;
                    }
                }
            }
        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(low,high+1);
    }
}