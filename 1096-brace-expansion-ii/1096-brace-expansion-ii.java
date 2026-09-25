class Solution {
    int idx;
    String s;
    int n;
    Set<String> getUnion(){
        Set<String> result = new TreeSet<>();
        while(true){
            Set<String> temp = getConcat();
            result.addAll(temp);
            if(idx < n && s.charAt(idx) == ',') idx++;
            else break;
        }
        return result;
    }
    Set<String> getConcat(){
        Set<String> result = new TreeSet<>();
        result.add("");
        while(idx<n && (s.charAt(idx) == '{' || Character.isLetter(s.charAt(idx)))){
            Set<String> temp = getUnit();
            Set<String> curr = new TreeSet<>();
            for(String left : result){
                for(String right : temp){
                    curr.add(left+right);
                }
            }
            result = curr;
        }
        return result;
    }
    Set<String> getUnit(){
        Set<String> result = new TreeSet<>();
        if(s.charAt(idx) == '{'){
            idx++;
            result = getUnion();
            idx++;
        }
        else{
            result.add(String.valueOf(s.charAt(idx++)));
        }
        return result;
    }
    public List<String> braceExpansionII(String expression) {
        n = expression.length();
        s = expression;
        idx = 0;
        Set<String> set = getUnion();
        return new ArrayList<>(set);
    }
}
