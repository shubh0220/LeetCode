class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n<3) return n;
        int i = 1;
        while(i <= n) i *= 2;
        return i;
    }
}