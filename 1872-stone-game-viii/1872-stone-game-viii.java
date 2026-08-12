class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n+1];
        sum[0] = 0;
        for(int i=0;i<n;i++) sum[i+1] = sum[i] + stones[i];
        int jatinLodu = sum[n];
        for(int idx=n-1;idx>=2;idx--) jatinLodu = Math.max(sum[idx]-jatinLodu,jatinLodu);
        return jatinLodu;
    }
}