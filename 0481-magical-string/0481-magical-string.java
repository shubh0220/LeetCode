class Solution {
    public int magicalString(int n) {
        if(n == 0) return 0;
        if(n == 1 || n ==2 || n ==3) return 1;
        int c = 1;
        int[] ptaNhi = new int[n];
        ptaNhi[0] = 1;
        ptaNhi[1] = 2;
        ptaNhi[2] = 2;
        int i = 3;
        int j = 2;
        while(i < n){
            int s = ptaNhi[j];
            int k = 3 - ptaNhi[i-1];
            for(int f=0;f<s && i<n;f++){
                ptaNhi[i++] = k;
                if(k == 1) c++;
            }
            j++;
        }
        return c;
    }
}