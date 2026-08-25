class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        int i = k;
        while(set.contains(i)) i += k;
        return i;
    }
}