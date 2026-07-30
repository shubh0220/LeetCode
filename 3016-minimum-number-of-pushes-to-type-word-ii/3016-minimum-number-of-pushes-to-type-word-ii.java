class Solution {
    public int minimumPushes(String word) {
        int N = word.length();
        int[] cnt = new int[26];
        for(char ch : word.toCharArray()) cnt[ch - 'a']++;
        int n = 0;
        for(int x : cnt) if(x>0) n++;
        if(n<=8) return N;
        Arrays.sort(cnt);
        int[] nums = new int[n];
        int i =0;
        for(int x : cnt) if(x > 0) nums[i++] = x;
        long ans = 0;
        if(n <= 16){
            for(int j=n-1;j>=n-8;j--) ans += nums[j];
            for(int j=0;j<n-8;j++) ans += 2*nums[j];
            return (int)ans;
        }
        else if(n<=24){
            for(int j=0;j<n-16;j++) ans += 3*nums[j];
            for(int j=n-16;j<n-8;j++) ans += 2*nums[j];
            for(int j=n-8;j<n;j++) ans += nums[j];
            return (int)ans;
        }
        for(int j=0;j<n-24;j++) ans += 4*nums[j];
        for(int j=n-24;j<n-16;j++) ans += 3*nums[j];
        for(int j=n-16;j<n-8;j++) ans += 2*nums[j];
        for(int j=n-8;j<n;j++) ans += nums[j];
        return (int)ans;
    }
}