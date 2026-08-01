class Solution {
    void helper(int idx,char last,int n,List<String> ans,StringBuilder sb){
        if(sb.length() == n){
            StringBuilder sb1 = new StringBuilder(sb);
            ans.add(sb.toString());
            return;
        }
        for(char ch = 'a';ch<='c';ch++){
            if(last == ch) continue;
            sb.append(ch);
            char ch1 = last;
            last = ch;
            helper(idx+1,last,n,ans,sb);
            sb.deleteCharAt(sb.length() - 1);
            last = ch1;
        }
    }
    public String getHappyString(int n, int k) {
        List<String> ans = new ArrayList<>();
        helper(0,'#',n,ans,new StringBuilder());
        if(k > ans.size()) return "";
        return ans.get(k-1);
    }
}