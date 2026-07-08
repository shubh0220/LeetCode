class Solution {
    static final int MOD = 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] pref = new int[s.length()+1];
        long[] digits = new long[s.length()+1];
        int[] n = new int[s.length()+1];
        pref[0] = 0;
        digits[0] = 0;
        n[0] =0;
        for(int i=0;i<s.length();i++){
            int d = s.charAt(i) - '0';
            if(d == 0){
                digits[i+1] = digits[i];
                n[i+1] = n[i];
            }
            else {
                digits[i+1] = (digits[i]*10 + d) % MOD;
                n[i+1] = n[i] + 1;
            }
            pref[i+1] = pref[i] + d;
        }
        long[] pow = new long[s.length() + 1];
        pow[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            pow[i] = (pow[i - 1] * 10) % MOD;
        }
        for(int i=0;i<queries.length;i++){
            int q0 = queries[i][0];
            int q1 = queries[i][1];
            long sum = pref[q1+1] - pref[q0];
            long left = digits[q0];
            long right = digits[q1+1];
            int diff = n[q1+1] - n[q0];
            long power = pow[diff];
            long k = (right - (left*power)%MOD + MOD)% MOD;
            long x = (k*sum)%MOD;
            ans[i] = (int)x;
        }
        return ans;
    }
}