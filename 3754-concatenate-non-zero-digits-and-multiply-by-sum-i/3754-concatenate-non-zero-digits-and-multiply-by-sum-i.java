class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);
        long t = 0;
        long sum = 0;
        for(char x : s.toCharArray()){
            if(x != '0'){
                int d = x - '0';
                t = t*10 + d;
                sum += d;
            }
        }
        return sum*t;
    }
}