class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int n = stones.length;
        for(int x : stones) sum += x;
        int target = (sum/2);
        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        if(stones[0] <= target) prev[stones[0]] = true;
        for(int i=1;i<n;i++){
            boolean[] curr = new boolean[target+1];
            curr[0] = true;
            for(int j=1;j<=target;j++){
                boolean not = prev[j];
                boolean take = false;
                if(stones[i] <= j) take = prev[j-stones[i]];
                curr[j] = not || take;
            }
            prev = curr;
        }
        int k = target;
        while (k >= 0 && !prev[k]) {
            k--;
        }
        return Math.abs(sum - 2 * k);
    }
}