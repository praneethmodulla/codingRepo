class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        sentence.trim();
        String[] str = sentence.split(" ");
        int i = 0;
        for(String s : str){
            i++;
            if(s.length() < searchWord.length()){
                continue;
            } else if(searchWord.equals(s.substring(0, searchWord.length()))){
                return i;
            }
        }
        return -1;
    }
}