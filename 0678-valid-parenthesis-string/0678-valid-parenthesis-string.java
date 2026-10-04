class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '(') open.push(i);
            else if(ch == '*') star.push(i);
            else{
                if(!open.isEmpty()) open.pop();
                else if(!star.isEmpty()) star.pop();
                else return false;
            }
        }
        while(!open.isEmpty() && !star.isEmpty()){
            int i = open.pop();
            int j = star.pop();
            if(i>j) return false;
        }
        return open.isEmpty();
    }
}