class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        if(n <= 8) return n;
        else if(n <= 16){
            int k = n- 8;
            return 8 + k*2;
        }
        else if(n<=24){
            int k = n - 16;
            return 24 + k*3;
        }
        return 48 + 4*(n-24);
    }
}