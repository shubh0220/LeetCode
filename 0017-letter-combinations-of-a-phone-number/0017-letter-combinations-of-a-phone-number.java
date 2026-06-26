class Solution {
    void helper(int id,String s,HashMap<Integer,String> map,List<String> ans,String st){
        if(id == s.length()){
            ans.add(st);
            return;
        }
        int digit = s.charAt(id) - '0';
        String l = map.get(digit);
        for(char ch : l.toCharArray()){
            helper(id+1,s,map,ans,st+ch);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> ans = new ArrayList<>();
        helper(0,digits,map,ans,"");
        return ans;
    }
}