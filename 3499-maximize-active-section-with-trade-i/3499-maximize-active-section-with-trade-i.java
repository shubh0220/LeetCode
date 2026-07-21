class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int prev = -1;
        int curr = 0;
        int ones = 0;
        boolean zero = false;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                ones++;
                if(zero){
                    if(prev != -1) max = Math.max(max,prev+curr);
                    prev = curr;
                    curr = 0;
                    zero = false;
                }
            }
            else{
                zero = true;
                curr++;
                if(prev == -1) continue;
            }
        }
        if (zero && prev != -1) {
            max = Math.max(max, prev + curr);
        }
        return ones + max;
    }
}