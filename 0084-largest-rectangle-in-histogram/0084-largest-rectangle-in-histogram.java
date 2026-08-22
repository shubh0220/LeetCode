class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()] > heights[i]){
                int ele = heights[s.pop()];
                int nse = i;
                int pse = s.isEmpty() ? -1 : s.peek();
                ans = Math.max(ele*(nse-pse-1),ans);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int ele = heights[s.pop()];
            int nse = n;
            int pse = s.isEmpty() ? -1 : s.peek();
            ans = Math.max(ele*(nse-pse-1),ans);
        }
        return ans;
    }
}