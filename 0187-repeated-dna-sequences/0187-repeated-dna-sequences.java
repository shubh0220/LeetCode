class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        Set<String> list = new HashSet<>();
        for(int i=0;i<=s.length()-10;i++){
            String l = s.substring(i,i+10);
            if(set.contains(l)) list.add(l);
            set.add(l);
        }
        return new ArrayList<>(list);
    }
}