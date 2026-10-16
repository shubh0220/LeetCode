class Solution {
    static final long MOD = 1_000_000_007L;
    int n;
    long[] tree;
    long[] sqTree;
    long[] lazyTree;
    void lazy(int node,int l,int r,long val){
        long len = r-l+1;
        sqTree[node] += 2*(val)*(tree[node]) + len*val*val;
        tree[node] += len*val;
    }
    void update(int node,int l,int r,int s,int e,int val){
        if(lazyTree[node] != 0){
            lazy(node,l,r,lazyTree[node]);
            if(l != r){
                lazyTree[2*node+1] += lazyTree[node];
                lazyTree[2*node+2] += lazyTree[node];
            }
            lazyTree[node] = 0;
        }
        if(l>e || r<s) return;
        if(l>=s && r<=e){
            lazy(node,l,r,val);
            if(l != r){
                lazyTree[2*node+1] += 1;
                lazyTree[2*node+2] += 1; 
            }
            return;
        }
        int mid = (l+r)/2;
        update(2*node+1,l,mid,s,e,val);
        update(2*node+2,mid+1,r,s,e,val);
        tree[node] = tree[2*node+1] + tree[2*node+2];
        sqTree[node] = sqTree[2*node+1] + sqTree[2*node+2];
    }
    public int sumCounts(int[] nums) {
        n = nums.length;
        tree = new long[4*n];
        sqTree = new long[4*n];
        lazyTree = new long[4*n];
        int[] lastSeenIdx = new int[100001];
        Arrays.fill(lastSeenIdx,-1);
        long result = 0;
        for(int i=0;i<n;i++){
            int s = lastSeenIdx[nums[i]] +1;
            int e = i;
            update(0,0,n-1,s,e,1);
            result = (result + sqTree[0]) % MOD;
            lastSeenIdx[nums[i]] = i;
        }
        return (int)result;
    }
}