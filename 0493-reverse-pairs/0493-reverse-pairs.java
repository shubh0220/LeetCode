class Solution {
    private int merge(int[] nums,int l,int h,int m){
        List<Integer> list = new ArrayList<>();
        int c = 0;
        int left = l;
        for(int right = m+1;right<=h;right++){
            long key = 2L *nums[right];
            while(left<=m && key >= nums[left]){
                left++;
            }
            c += m-left+1;
        }
        left = l;
        int right = m+1;
        while(left <= m && right<=h){
            if(nums[left] <= nums[right])list.add(nums[left++]);
            else list.add(nums[right++]);
        }
        while(left<=m){
            list.add(nums[left++]);
        }
        while(right<=h){
            list.add(nums[right++]);
        }
        for(int i = l;i<=h;i++){
            nums[i] = list.get(i-l);
        }
        return c;
    }
    private int mergeSort(int[] nums,int l,int h){
        if(l == h) return 0;
        int c =0;
        int m = (l+h)/2;
        c += mergeSort(nums,l,m);
        c += mergeSort(nums,m+1,h);
        c += merge(nums,l,h,m);
        return c;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
}