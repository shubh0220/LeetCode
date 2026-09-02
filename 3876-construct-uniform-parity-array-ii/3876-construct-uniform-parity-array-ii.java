class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int mn = Integer.MAX_VALUE;
        boolean odd = true;
        for(int x : nums1){
            mn = Math.min(x,mn);
            if(x%2 == 1) odd = false;
        }
        if(mn%2 == 1) return true;
        return odd;
    }
}