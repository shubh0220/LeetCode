class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int k = needle.length();
        if(k>n) return -1;
        if(haystack.equals(needle)) return 0;
        int l =0;
        for(int r = k-1;r<n;r++){
            if(r-l+1 > k) l++;
            if(haystack.substring(l,r+1).equals(needle)) return l;
        }
        return -1;
    }
}