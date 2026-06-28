class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        Arrays.sort(occupiedIntervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> merged = new ArrayList<>();
        for(int[] x : occupiedIntervals){
            if(merged.isEmpty() || x[0] > merged.get(merged.size()-1)[1] +1){
                merged.add(new int[]{x[0],x[1]});
            }
            else{
                merged.get(merged.size()-1)[1] = 
                    Math.max(merged.get(merged.size()-1)[1],x[1]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int[]x : merged){
            int l = x[0];
            int r = x[1];
            if(r<freeStart || l > freeEnd){
                ans.add(Arrays.asList(l,r));
                continue;
            }
            if(l<freeStart) ans.add(Arrays.asList(l,freeStart-1));
            if(r>freeEnd) ans.add(Arrays.asList(freeEnd+1,r));
        }
        return ans;
    }
}