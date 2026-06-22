class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            m = Math.min(m, arr[i + 1] - arr[i]);
        }
        for(int i=0;i<arr.length-1;i++){
            List<Integer> list;
            if(arr[i+1] - arr[i] == m){
                list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                ans.add(list);
            }
        }
        return ans;
    }
}