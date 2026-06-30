class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for(int x : cardPoints){
            sum += x;
        }
        int l = 0;
        int sum1 = 0;
        int ans =0;
        for(int e=0;e<n;e++){
            sum1 += cardPoints[e];
            if(e-l+1 > n-k){
                sum1 -= cardPoints[l];
                l++;
            }
            if (e - l + 1 == n - k) {
                ans = Math.max(ans, sum - sum1);
            }
        }
        return ans;
    }
}