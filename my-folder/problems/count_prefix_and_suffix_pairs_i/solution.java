class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(isPrefixAndSuffix(words[i], words[j])){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public boolean isPrefixAndSuffix(String str1, String str2){
        if(str1.length() > str2.length()){
            return false;
        }
        if(str1.equals(str2.substring(0, str1.length()))){
            if(str1.equals(str2.substring(str2.length() - str1.length(), str2.length()))){
                return true;
            }
            return false;
        }
        return false;
    }
}