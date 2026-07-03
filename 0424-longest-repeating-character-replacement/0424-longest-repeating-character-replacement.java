class Solution {
    public int characterReplacement(String s, int k) {
        int l =0;
        int ans = 0;
        int[] freq = new int[26];
        int maxfreq = 0;
        for(int r=0;r<s.length();r++){
            freq[s.charAt(r) - 'A']++;
            maxfreq = Math.max(maxfreq,freq[s.charAt(r) - 'A']);
            if((r-l+1)-maxfreq >k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}