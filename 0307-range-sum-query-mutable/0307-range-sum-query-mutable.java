class NumArray {
    int n;
    int[] tree;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[4 * n];
        build(0, 0, n - 1);
    }

    void build(int idx,int low,int high){
        if(low == high){
            tree[idx] = nums[low];
            return;
        }
        int mid = (low+high)/2;
        build(2*idx+1,low,mid);
        build(2*idx+2,mid+1,high);
        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
    }

    int query(int idx,int low,int high,int l,int h){
        if(low>=l && high<=h) return tree[idx];
        if(low>h || high <l) return 0;
        int mid = (low+high)/2;
        int left = query(2*idx+1,low,mid,l,h);
        int right = query(2*idx+2,mid+1,high,l,h);
        return left + right;
    }
    void updateTree(int idx,int low,int high,int index,int val){
        if(low == high){
            nums[index] = val;
            tree[idx] = val;
            return;
        }
        int mid = (low+high)/2;
        if(index <= mid) updateTree(2*idx+1,low,mid,index,val);
        else updateTree(2*idx+2,mid+1,high,index,val);
        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
    }

    public void update(int index, int val) {
        updateTree(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */