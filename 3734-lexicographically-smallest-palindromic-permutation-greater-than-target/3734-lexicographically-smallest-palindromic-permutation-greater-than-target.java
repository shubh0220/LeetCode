class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = target.length();
        int[] freq = new int[26];
        char midChar = '#';
        int odd = 0;
        for(char ch : s.toCharArray()) freq[ch-'a']++;
        for(int x=0;x<26;x++){
            if(freq[x] %2 == 1){
                odd++;
                midChar = (char)(x+'a');
            }
            freq[x] /= 2;
        }
        if(odd >1) return "";
        StringBuilder sb = new StringBuilder();
        int m = -1;
        for(int i=0;i<n/2;i++){
            int curr = target.charAt(i) - 'a';
            if(freq[curr]>0){
                sb.append((char)(curr+'a'));
                freq[curr]--;
            }
            else{
                m = i;
                break;
            }
        }
        if(m != -1){
            int curr = target.charAt(m)-'a';
            for(int j=curr+1;j<26;j++){
                if(freq[j]>0){
                    StringBuilder ans = new StringBuilder(sb);
                    ans.append((char)(j+'a'));
                    freq[j]--;
                    for(int k=0;k<26;k++){
                        while(freq[k]>0){
                            ans.append((char)(k+'a'));
                            freq[k]--;
                        }
                    }
                    if(midChar != '#') return ans.toString()+midChar+ans.reverse().toString();
                    return ans.toString() + ans.reverse().toString();
                }
            }
        }
        if(m == -1 && n % 2 == 1){
            String left = sb.toString();
            String right = new StringBuilder(left).reverse().toString();
            String candidate = left + midChar + right;
            if(candidate.compareTo(target) > 0) return candidate;
        }
        if(m == -1 && n % 2 == 0){
            String left = sb.toString();
            String right =left + new StringBuilder(left).reverse().toString();
            if(right.compareTo(target) > 0) return right;
        }
       for(int i=sb.length()-1;i>=0;i--){
            int curr = sb.charAt(i) - 'a';
            freq[curr]++;
            for(int j=curr+1;j<26;j++){
                if(freq[j]>0){
                    StringBuilder ans = new StringBuilder(sb.substring(0, i));
                    ans.append((char)(j+'a'));
                    freq[j]--;
                    for(int k=0;k<26;k++){
                        while(freq[k]>0){
                            ans.append((char)(k+'a'));
                            freq[k]--;
                        }
                    }
                    if(midChar != '#') return ans.toString()+midChar+ans.reverse().toString();
                    return ans.toString() + ans.reverse().toString();
                }
            }
        }
        return "";
    }
}