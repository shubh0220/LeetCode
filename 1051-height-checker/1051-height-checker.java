class Solution {
    public int heightChecker(int[] heights) {
        int max = heights[0];
        for (int x : heights) {
            max = Math.max(max, x);
        }
        int[] count = new int[max + 1];
        for (int x : heights) {
            count[x]++;
        }
        int[] arr = new int[heights.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] != heights[i]) c++;
        }
        return c;
    }
}