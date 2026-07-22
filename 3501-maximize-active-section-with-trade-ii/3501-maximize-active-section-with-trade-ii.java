class Solution {
    int lowerBound(List<Integer> arr, int target) {
    int l = 0, r = arr.size() - 1;
    int ans = arr.size();
    while (l <= r) {
        int mid = (r + l) / 2;
        if (arr.get(mid) >= target) {
            ans = mid;
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return ans;
}
    int upperBound(List<Integer> arr, int target) {
        int l = 0, r = arr.size() - 1;
        int ans = arr.size();
        while (l <= r) {
            int mid = (r + l) / 2;
            if (arr.get(mid) > target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    void build(int idx,int low,int high,int[] st,int[] nums){
        if(low == high){
            st[idx] = nums[low];
            return;
        }
        int mid = (low+high)/2;
        build(2*idx+1,low,mid,st,nums);
        build(2*idx+2,mid+1,high,st,nums);
        st[idx] = Math.max(st[2*idx+1],st[2*idx+2]);
    }
    int query(int idx,int low,int high,int l,int r,int[] st){
        if(low>=l && high<=r) return st[idx];
        if(low >r || high <l) return Integer.MIN_VALUE;
        int mid = (low+high)/2;
        int left = query(2*idx+1,low,mid,l,r,st);
        int right = query(2*idx+2,mid+1,high,l,r,st);
        return Math.max(left,right);
    }
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int curr = 0;
        int ones = 0;
        boolean zero = false;
        boolean one = false;
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        List<Integer> len = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') ones++;
        }
        int k = 0;
        while (k < n) {
            if (s.charAt(k) == '0') {
                int st = k;
                while (k < n && s.charAt(k) == '0') {
                    k++;
                }
                start.add(st);
                end.add(k - 1);
                len.add(k - st);
            } else {
                k++;
            }
        }   
        if(len.size() < 2){
            for(int[] q : queries){
                ans.add(ones);
            }
            return ans;
        }
        int[] pairSum = new int[len.size()-1];
        for(int i=0;i<len.size()-1;i++){
            pairSum[i] = len.get(i) + len.get(i+1);
        }
        int n1 = pairSum.length;
        int[] st = new int[4*n1];
        if(n1 > 0) build(0,0,n1-1,st,pairSum);
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            int low = lowerBound(end,l);
            int high = upperBound(start,r)-1;
            int max = 0;
            if(low < high){
                int len1 = end.get(low) - Math.max(start.get(low), l) + 1;
                int len2 = Math.min(end.get(high), r) - start.get(high) + 1;
                if(high - low == 1) max = len1 + len2;
                else{
                    int first = len1 + len.get(low+1);
                    int last = len2 + len.get(high-1);
                    max = query(0,0,n1-1,low+1,high-2,st);
                    max = Math.max(max,Math.max(first,last));
                }
            }
            ans.add(max+ones);
        }
        return ans;
    }
}