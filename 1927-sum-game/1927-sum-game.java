class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum  =0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;
        for(int i=0;i<n/2;i++){
            char ch = num.charAt(i);
            if(ch == '?') leftQ++;
            else leftSum += ch - '0';
        }
        for(int i=n/2;i<n;i++){
            char ch = num.charAt(i);
            if(ch == '?') rightQ++;
            else rightSum += ch - '0';
        }
        if((rightQ+leftQ) %2 == 1) return true;
        int diff = Math.abs(leftSum - rightSum);
        int qDiff = Math.abs(leftQ - rightQ);
        return leftSum-rightSum != 9*(rightQ - leftQ)/2;
    }
}