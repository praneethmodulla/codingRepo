class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < wordDict.size(); i++){
            set.add(wordDict.get(i));
        }
        List<String> sentence = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        recurse(s, sentence, sb, 0, set);
        return sentence;
    }

    public void recurse(String s, List<String> sen, StringBuilder sb, int idx, HashSet<String> set){
        if(idx == s.length()){
            sen.add(sb.toString().substring(0, sb.length() - 1));
            return;
        }
        for(int i = idx + 1; i <= s.length(); i++){
            if(set.contains(s.substring(idx, i))){
                String word = s.substring(idx, i);
                sb.append(word + " ");
                recurse(s, sen, sb, i, set);
                int start = sb.lastIndexOf(word);
                if(start != -1){
                    int end = start + word.length();
                    sb.replace(start, end, "");
                }
                if(sb.length() > 0 && sb.charAt(sb.length() - 1) == ' '){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return;
    }

}