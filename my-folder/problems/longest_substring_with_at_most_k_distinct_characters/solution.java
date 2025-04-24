class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int leftPtr = 0;
        int rightPtr = 0;
        int maxLen = 0;
        for(rightPtr = 0; rightPtr < s.length(); rightPtr++){
            map.put(s.charAt(rightPtr), map.getOrDefault(s.charAt(rightPtr), 0) + 1);
            while(map.size() > k){
                map.put(s.charAt(leftPtr), map.get(s.charAt(leftPtr)) - 1);
                if(map.get(s.charAt(leftPtr)) == 0){
                    map.remove(s.charAt(leftPtr));
                }
                leftPtr++;
            }
            if(map.size() <= k){
                maxLen = Math.max(maxLen, rightPtr - leftPtr + 1);
            }
        }
        return maxLen;
    }
}