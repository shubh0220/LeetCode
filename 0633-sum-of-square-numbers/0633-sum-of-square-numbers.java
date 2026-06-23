class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0;
        int h = (int)(Math.sqrt(c));
        while(h>=l){
            if((long)l*l +(long)h*h == c) return true;
            else if((long)l*l +(long)h*h < c) l = l+1;
            else h = h-1;
        }
        return false;
    }
}