class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int numVowels = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(right = 0; right < s.length(); right++){
            if(set.contains(s.charAt(right))){
                numVowels++;
            }
            if(right - left + 1 > k){
                if(set.contains(s.charAt(left))){
                    numVowels--;
                }
                left++;
            }
            if(max < numVowels){
                max = numVowels;
            }
        }
        return max;
    }
}