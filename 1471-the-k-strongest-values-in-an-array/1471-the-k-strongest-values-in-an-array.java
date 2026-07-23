class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int m = arr[(n-1)/2];
        int[] ans = new int[k];
        int l = 0;
        int r = n-1;
        for(int i=0;i<k;i++){
            if(Math.abs(arr[r]-m) >= Math.abs(arr[l]-m)) ans[i] = arr[r--];
            else ans[i] = arr[l++];
        }
        return ans;
    }
}