class Solution {
    private void merge(int[] nums,int l,int h,int m){
        List<Integer> list = new ArrayList<>();
        int left = l;
        int right = m+1;
        while(left <= m && right <= h){
            if(nums[left] <= nums[right]) list.add(nums[left++]);
            else list.add(nums[right++]);
        }
        while(left <= m){
            list.add(nums[left++]);
        }
        while(right <= h){
            list.add(nums[right++]);
        }
        for(int i = l;i<=h;i++){
            nums[i] = list.get(i-l);
        }
    }
    private void mergeSort(int[] nums,int l,int h){
        if(l == h) return;
        int m = (l+h)/2;
        mergeSort(nums,l,m);
        mergeSort(nums,m+1,h);
        merge(nums,l,h,m);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}