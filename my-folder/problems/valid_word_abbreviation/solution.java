class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int idx = 0;
        int i = 0;
        while(i < abbr.length()){
            if(idx < word.length() && abbr.charAt(i) == word.charAt(idx)){
                idx++;
                i++;
            } else if(abbr.charAt(i) >= '1' && abbr.charAt(i) <= '9'){
                StringBuilder sb = new StringBuilder();
                while(i < abbr.length() && abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9'){
                    sb.append(abbr.charAt(i));
                    i++;
                }
                int subLength = Integer.valueOf(sb.toString());
                if(idx + subLength > word.length()){
                    return false;
                } else {
                    idx += (subLength);
                }
            } else {
                return false;
            }
        }
        if(idx < word.length()){
            return false;
        }
        return true;
    }
}