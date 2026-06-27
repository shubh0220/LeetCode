class Solution {
    void helper(String s,int target,int i,String st,List<String> ans,long e,long r){
        if(i == s.length()){
            if(e == target)ans.add(new String(st));
            return;
        }
        String str = "";
        long num = 0;
        for(int j =i;j<s.length();j++){
            if(j>i && s.charAt(i) == '0') return;
            str = str + s.charAt(j);
            num = num*10 + (s.charAt(j) - '0');
            if(i ==0 ) helper(s,target,j+1,st + str,ans,num,num);
            else{
                helper(s,target,j+1,st + "+" + str,ans,e+num,num);
                helper(s,target,j+1,st + "-" + str,ans,e-num,(-1)*num);
                helper(s,target,j+1,st + "*" + str,ans,e-r + r*num,r*num);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        helper(num,target,0,"",ans,0,0);
        return ans;
    }
}