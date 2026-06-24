class Solution {
    public List<Integer> helper(int n){
        if(n == 1) return new ArrayList<>(List.of(1));
        List<Integer> evens = helper(n/2);
        List<Integer> odds = helper(n-n/2);
        List<Integer> ans = new ArrayList<>();
        for(int x : evens) ans.add(2*x);
        for(int x : odds) ans.add(2*x-1);

        return ans;
    }
    public int[] beautifulArray(int n) {
        List<Integer> list = helper(n);
        int[] ans= new int[n];
        for(int i=0;i<n;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}