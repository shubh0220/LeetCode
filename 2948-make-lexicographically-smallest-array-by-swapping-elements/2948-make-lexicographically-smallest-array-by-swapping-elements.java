class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int group = 0;
        HashMap<Integer,Integer> numToGroup = new HashMap<>();
        HashMap<Integer,LinkedList<Integer>> groupToList = new HashMap<>();
        numToGroup.put(arr[0],group);
        groupToList.putIfAbsent(group,new LinkedList<>());
        groupToList.get(group).add(arr[0]);
        for(int i=1;i<n;i++){
            if(Math.abs(arr[i]-arr[i-1]) > limit) group++;
            numToGroup.put(arr[i],group);
            groupToList.putIfAbsent(group,new LinkedList<>());
            groupToList.get(group).add(arr[i]); 
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = groupToList.get(numToGroup.get(nums[i])).pollFirst();
        }
        return ans;
    }
}