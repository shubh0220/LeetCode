class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MIN_VALUE;
        for(int x : nums){
            m1 = Math.min(x,m1);
            m2 = Math.max(x,m2);
            set.add(x);
        }
        for(int i=m1;i<=m2;i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}