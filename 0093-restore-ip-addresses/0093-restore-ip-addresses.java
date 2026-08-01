class Solution {
    void helper(int idx,String s,List<String> ans,List<String> list){
        if(list.size() == 4){
            if(idx == s.length()){
                ans.add(String.join(".", list));
            }
            return;
        }
        for(int i=1;i<=3 && idx+i<=s.length();i++){
            String s1 = s.substring(idx,idx+i);
            if (s1.length() > 1 && s1.charAt(0) == '0') break;
            int digit = Integer.parseInt(s1);
            if(digit <= 255){
                list.add(s1);
                helper(idx+i,s,ans,list);
                list.remove(list.size()-1);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(0,s,ans,new ArrayList<>());
        return ans;
    }
}