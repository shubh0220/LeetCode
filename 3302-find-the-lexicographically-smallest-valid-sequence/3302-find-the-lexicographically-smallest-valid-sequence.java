class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(m == 1) return new int[]{0};
        int[] nums = new int[m];
        int[] ans = new int[m];
        Arrays.fill(nums,-1);
        int j = m-1;
        for(int i=n-1;i>=0;i--){
            if(j>=0 && word1.charAt(i) == word2.charAt(j)) nums[j--] = i;
        }
        j = 0;
        boolean taken = false;
        for(int i=0;i<n;i++){
            if(j == m) break;
            if(word1.charAt(i) == word2.charAt(j)) ans[j++] = i;
            else if(!taken && (j == m-1 || nums[j+1] >= i+1)){
                taken = true;
                ans[j++] = i;
            }
        }
        if(j == m) return ans;
        return new int[0];
    }
}