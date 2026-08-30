class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int mn = 0;
        int mx = 0;
        for(int i=0;i<n;i++){
            if(nums[i] < nums[mn]) mn = i;
            if(nums[i] > nums[mx]) mx = i;
        }
        int c1 = Math.max(mn,mx) +1;
        int c2 = n - Math.min(mn,mx);
        int d1 = Math.min(Math.abs(mn-0),Math.abs(mx-0));
        int d2 = Math.min(Math.abs(mn-(n-1)),Math.abs(mx-(n-1)));
        int c3 = d1+d2+2;
        return Math.min(c1,Math.min(c2,c3));
    }
}