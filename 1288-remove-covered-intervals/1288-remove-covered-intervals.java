class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return 1;
        int c = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j) continue;
                if(intervals[i][0]>=intervals[j][0] && intervals[i][1]<=intervals[j][1]){
                    c++;
                    break;
                }
            }
        }
        return n-c;
    }
}