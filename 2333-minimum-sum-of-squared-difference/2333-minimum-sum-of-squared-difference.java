class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long tk = k1+k2;
        int N = 100000;
        long[] diff = new long[N+1];
        for(int i=0;i<n;i++) diff[Math.abs(nums1[i]-nums2[i])]++;
        for(int i=N;i>0 && tk>0;i--){
            long avl = Math.min(diff[i],tk);
            diff[i] -= avl;
            diff[i-1] += avl;
            tk -= avl;
        }
        long ans = 0;
        for(int i=0;i<=N;i++) ans += (long)i*i*(diff[i]);
        return ans;
    }
}