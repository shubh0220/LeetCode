class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] count = new int[32];
        for(int x : nums){
            for(int i=0;i<32;i++) if ((x&(1<<i)) != 0) count[i]++;
        }
        long result = 0;
        while(k-->0){
            long curr = 0;
            for(int i=0;i<32;i++){
                if(count[i]>0) {
                    curr = curr|(1L<<i);
                    count[i]--;
                }
            }
            result += (curr*curr)%MOD;
        }
        result %= MOD;
        return (int)result;
    }
}