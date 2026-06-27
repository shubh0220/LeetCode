class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer> map = new HashMap<>();
        int ans = 1;
        for(int x : nums){
            map.put((long)x,map.getOrDefault((long)x,0)+1);
        }
        if (map.containsKey(1L)) {
                int cnt = map.get(1L);
                ans = (cnt % 2 == 0) ? cnt - 1 : cnt;
            }
        for(long x : map.keySet()){
            if(x==1) continue;
            long key = x;
            int k =1;
            while(map.containsKey(key*key)){
                long j = key*key;
                if(map.get(key) < 2) break;
                key = j;
                k = k+2;
            }
            ans = Math.max(ans,k);
        }
        return ans; 
    }
}