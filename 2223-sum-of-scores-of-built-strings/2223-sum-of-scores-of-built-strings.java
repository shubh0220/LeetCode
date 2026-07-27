class Solution {
    public long sumScores(String s) {
        int n = s.length();
        long ans = n;
        int[] z = new int[n];
        int left = 0;
        int right = 0;
        z[0] = 0;
        for(int i=1;i<n;i++){
            if(i>right){
                left = i; right = i;
                while(right <n && s.charAt(right) == s.charAt(right-left)) right++;
                z[i] = right-left;
                ans += z[i];
                right--;
            }
            else{
                int k = i - left;
                if(z[k] < right-i+1){
                    z[i] = z[k];
                    ans += z[i];
                }
                else{
                    left = i;
                    while(right <n && s.charAt(right) == s.charAt(right-left)) right++;
                    z[i] = right-left;
                    ans += z[i];
                    right--;
                }
            }
        }
        return ans;
    }
}