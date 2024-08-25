class Solution {
    public int lengthOfLongestSubstring(String s) {
        int leftPointer = 0;
        int rightPointer = 0;
        int len = 0;
        HashSet<Character> set = new HashSet<>();
        for(rightPointer = 0; rightPointer < s.length(); rightPointer++){
            while(set.contains(s.charAt(rightPointer))){
                set.remove(s.charAt(leftPointer));
                leftPointer++;
            }
            if(!set.contains(s.charAt(rightPointer))){
                set.add(s.charAt(rightPointer));
                if(len < rightPointer - leftPointer + 1){
                    len = rightPointer - leftPointer + 1;
                }
            }
        }
        return len;
    }
}