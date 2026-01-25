class Solution {
    public int maxDistinct(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(!set.contains(s.charAt(i))){
                count++;
                set.add(s.charAt(i));
            }
        }
        return count;
    }
}