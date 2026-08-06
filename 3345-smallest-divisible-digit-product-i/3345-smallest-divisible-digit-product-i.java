class Solution {
    int digitMulti(int n){
        int m = 1;
        while(n>0){
            m *= n%10;
            n = n/10;
        }
        return m;
    }
    public int smallestNumber(int n, int t) {
        while(digitMulti(n) % t != 0) n++;
        return n;
    }
}