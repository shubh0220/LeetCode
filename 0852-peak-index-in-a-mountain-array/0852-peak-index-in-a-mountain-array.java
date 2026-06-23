class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l =0;
        int h = arr.length-1  ;
        while(h>l){
            int m = (l+h)/2;
            if(arr[m] < arr[m+1]) l = m+1;
            else h = m;
        }
        return h;
    }
}