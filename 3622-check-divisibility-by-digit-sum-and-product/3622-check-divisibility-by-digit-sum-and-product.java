class Solution {
    public boolean checkDivisibility(int n) {
        long N = n;
        long sum = 0;
        long mult = 1;
        while(N >0){
            long digit = N%10;
            N /= 10;
            sum += digit;
            mult *= digit;
        }
        return (n % (sum+mult) == 0);
    }
}