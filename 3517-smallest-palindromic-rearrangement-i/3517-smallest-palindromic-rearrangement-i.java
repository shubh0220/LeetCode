class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n==0 || n==1) return s;
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        for(char c : s.toCharArray()) cnt[c-'a']++;
        for(int i=0;i<26;i++){
            int k = cnt[i];
            while(k>1){
                char c = (char)('a'+i);
                sb.append(c);
                k -=2;
            }
        }
        StringBuilder ans = new StringBuilder(sb);
        if(n%2 != 0) ans.append(s.charAt(n/2));
        ans.append(sb.reverse());
        return ans.toString();
    }
}