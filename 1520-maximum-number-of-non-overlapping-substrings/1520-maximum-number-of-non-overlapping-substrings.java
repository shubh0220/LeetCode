class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] start = new int[26];
        Arrays.fill(start,-1);
        int[] end = new int[26];
        for(int i=0;i<n;i++){
            int idx = s.charAt(i) -'a';
            if(start[idx] == -1) start[idx] = i;
            end[idx] = i;
        }
        boolean[] isValid = new boolean[26];
        Arrays.fill(isValid,true);
        for(int i=0;i<26;i++){
            if(start[i] == -1) continue;
            for(int j=start[i];j<=end[i];j++){
                if(start[s.charAt(j)-'a'] < start[i]){
                    isValid[i] = false;
                    break;
                }
                end[i] = Math.max(end[i],end[s.charAt(j)-'a']);
            }
        }
        List<String> ans = new ArrayList<>();
        int prev = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            int idx = s.charAt(i) -'a';
            if(!isValid[idx]) continue;
            if(start[idx] == i && end[idx]<prev){
                ans.add(s.substring(i,end[idx]+1));
                prev = i;
            }
        }
        return ans;
    }
}