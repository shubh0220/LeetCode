class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') count++;
            else{
                if(count == 0) ans++;
                else count--;
            }
        }
        return ans+count;
    }
}