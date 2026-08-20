class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char x : t.toCharArray()){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int l =0;
        HashMap<Character,Integer> freq = new HashMap<>();
        int formed = 0;
        int len = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for(int r=0;r<m;r++){
            char ch = s.charAt(r);
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            if(map.containsKey(ch) && map.get(ch).equals(freq.get(ch))) formed++;
            while(formed == map.size()){
                if(r-l+1 <len){
                    len = r-l+1;
                    i = l;
                    j = r;
                }
                char c = s.charAt(l++);
                freq.put(c,freq.get(c)-1);
                if(map.containsKey(c) && freq.get(c) < map.get(c)) formed--;
            }
        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(i,j+1);
    }
}