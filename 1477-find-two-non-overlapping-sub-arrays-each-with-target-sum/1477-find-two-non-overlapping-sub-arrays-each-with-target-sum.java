class Solution {
    int next(List<int[]> list,int k){
        int l = 0;
        int h = list.size()-1;
        int ans = list.size();
        while(h>=l){
            int m = (l+h)/2;
            if(list.get(m)[0] > k){
                ans = m;
                h=m-1;
            }
            else l = m+1;
        }
        return ans;
    }
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int l=0;
        List<int[]> list = new ArrayList<>();
        int sum = 0;
        for(int r=0;r<n;r++){
            sum += arr[r];
            while(sum > target && l<=r) sum -= arr[l++];
            if(sum == target) list.add(new int[]{l,r});
        }
        n = list.size();
        if(n<2) return -1;
        int[] dp = new int[n+1];
        dp[n] = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            int len = list.get(i)[1] - list.get(i)[0] + 1;
            dp[i] = Math.min(len,dp[i+1]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int next = next(list,list.get(i)[1]);
            if(next < n){
                int len = list.get(i)[1] - list.get(i)[0] + 1;
                ans = Math.min(ans,len+dp[next]);
            }
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}