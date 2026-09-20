class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i) - 'a';
            ans += (26-idx)*(i+1);
        }
        return ans;
    }
}