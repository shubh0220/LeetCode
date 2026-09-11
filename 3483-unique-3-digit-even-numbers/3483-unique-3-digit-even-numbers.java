class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for(int x=0;x<n;x++){
            if(digits[x] == 0) continue;
            for(int y=0;y<n;y++){
                if(y == x) continue;
                for(int z=0;z<n;z++){
                    if(z == x || z == y || digits[z]%2 != 0) continue;
                    int num = 100*digits[x] + 10*digits[y] + digits[z];
                    set.add(num);
                }
            }
        }
        return set.size();
    }
}