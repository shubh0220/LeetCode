class Solution {
    private int merge(int[] nums,int l,int h,int m){
        List<Integer> list = new ArrayList<>();
        int right = m + 1;
        int c =0;
        for (int left = l; left <= m; left++) {
            while (right <= h && nums[right] <= nums[left]) {
                right++;
            }
            c += (h - right + 1);
        }
        int left = l;
        right = m+1;
        while(left <= m && right <= h){
            if(nums[left] <= nums[right]){
                list.add(nums[left++]);
            }
            else list.add(nums[right++]);
        }
        while(left <= m){
            list.add(nums[left++]);
        }
        while(right <= h){
            list.add(nums[right++]);
        }
        for(int i = l;i<=h;i++){
            nums[i] = list.get(i-l);
        }
        return c;
    }
    private int mergeSort(int[] nums,int l,int h){
        int c =0;
        if(l == h) return c;
        int m = (l+h)/2;
        c += mergeSort(nums,l,m);
        c += mergeSort(nums,m+1,h);
        c += merge(nums,l,h,m);
        return c;
    }
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] sbs = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i] == target) sbs[i] = 1;
            else sbs[i] = -1;
        }
        int[] preSum = new int[n+1];
        for(int i=0;i<n;i++){
            preSum[i+1] = preSum[i] + sbs[i];
        }
        int ans = mergeSort(preSum,0,n);
        return ans;
    }
}