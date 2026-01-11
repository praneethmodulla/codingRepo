class Solution {
    public int maxLength(List<String> arr) {
        int[] freq = new int[26];
        int[] max = new int[1];
        StringBuilder sb = new StringBuilder();
        recurse(arr, 0, freq, max, sb);
        return max[0];
    }

    public void recurse(List<String> arr, int idx, int[] freq, int[] max, StringBuilder sb){
        if(arr.size() == idx){
            if(max[0] < sb.length()){
                max[0] = sb.length();
            }
            return;
        }
        recurse(arr, idx + 1, freq, max, sb);
        if(check(arr.get(idx), freq)){
            for(int i = 0; i < arr.get(idx).length(); i++){
                freq[arr.get(idx).charAt(i) - 'a']++;
            }
            sb.append(arr.get(idx));
            recurse(arr, idx + 1, freq, max, sb);
            for(int i = 0; i < arr.get(idx).length(); i++){
                freq[arr.get(idx).charAt(i) - 'a']--;
            }
            int len = arr.get(idx).length();
            for(int i = 0; i < len; i++){
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    public boolean check(String word, int[] freq){
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < word.length(); i++){
            if(!set.contains(word.charAt(i))){
                if(freq[word.charAt(i) - 'a'] + 1 == 1){
                    set.add(word.charAt(i));
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}