class Solution {
    long GCD(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    long LCM(long a, long b) {
        return a / GCD(a, b) * b;
    }
    long count(long x,int[] coins){
        int n = coins.length;
        long ans = 0;
        for(int mask =1;mask < (1 << n);mask++){
            long lcm = 1;
            for(int i=0;i<n;i++){
                if((mask & (1 << i)) != 0) lcm = LCM(lcm,coins[i]);
            }
            int bits = Integer.bitCount(mask);
            if(bits%2 == 1) ans += x/lcm;
            else ans -= x/lcm;
        }
        return ans;
    }
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        long minCoin = coins[0];
        for(int x : coins) minCoin = Math.min(x,minCoin);
        long l = 1;
        long h = k*minCoin;
        while(l<h){
            long mid = (l+h)/2;
            if(count(mid,coins) >= k) h = mid;
            else l = mid+1;
        }
        return l;
    }
}