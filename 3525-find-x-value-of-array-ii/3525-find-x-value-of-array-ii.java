class Solution {
    class Node{
        long product;
        long[] suffix;
        long[] prefix;
    }
    int n;
    int[] nums;
    Node[] tree;
    int k;
    void build(int node,int l,int h){
        if(l==h){
            tree[node] = new Node();
            tree[node].product = nums[l]%k;
            tree[node].suffix = new long[k];
            tree[node].prefix = new long[k];
            int rem = nums[l]%k;
            tree[node].prefix[rem] = 1;
            tree[node].suffix[rem] = 1;
            return;
        }
        int m = (l+h)/2;
        build(2*node+1,l,m);
        build(2*node+2,m+1,h);
        tree[node] = merge(tree[2*node+1],tree[2*node+2]);
    }
    Node merge(Node left,Node right){
        Node parent = new Node();
        parent.product = (left.product*right.product)%k;
        long[] prefix = new long[k];
        for(int i=0;i<k;i++) prefix[i] = left.prefix[i];
        for(int i=0;i<k;i++){
            if(right.prefix[i] == 0) continue;
            int newRem = (int)(left.product*i)%k;
            prefix[newRem] += right.prefix[i];
        }
        parent.prefix = prefix;
        long[] suffix = new long[k];
        for(int i=0;i<k;i++) suffix[i] = right.suffix[i];
        for(int i=0;i<k;i++){
            if(left.suffix[i] == 0) continue;
            int newRem = (int)(right.product*i)%k;
            suffix[newRem] += left.suffix[i];
        }
        parent.suffix = suffix;
        return parent;
    }
    Node query(int node,int l,int h,int ql,int qr){
        if(l>qr || h<ql) return null;
        if(l>=ql && h<=qr) return tree[node];
        int m = (l+h)/2;
        Node left = query(2*node+1,l,m,ql,qr);
        Node right = query(2*node+2,m+1,h,ql,qr);
        if(left == null) return right;
        if(right == null) return left;
        return merge(left,right);
    }
    void update(int node,int l,int h,int idx,int value){
        if(l == h){
            tree[node].product = value%k;
            int rem1 = value%k;
            Arrays.fill(tree[node].prefix, 0);
            Arrays.fill(tree[node].suffix, 0);
            int rem = value%k;
            tree[node].prefix[rem] = 1;
            tree[node].suffix[rem] = 1;
            return;
        }
        int m = (l+h)/2;
        if(idx<=m) update(2*node+1,l,m,idx,value);
        else update(2*node+2,m+1,h,idx,value);
        tree[node] = merge(tree[2*node+1],tree[2*node+2]);
    }
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.nums = nums;
        this.tree = new Node[4*n];
        this.k = k;
        build(0,0,n-1);
        int m = queries.length;
        int[] result = new int[m];
        int i=0;
        for(int[] arr : queries){
            int idx = arr[0];
            int value = arr[1];
            int start = arr[2];
            int x = arr[3];
            update(0,0,n-1,idx,value);
            Node ans = query(0,0,n-1,start,n-1);
            result[i++] = (int)(ans.prefix[x]);
        }
        return result;
    }
}