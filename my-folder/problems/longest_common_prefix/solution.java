class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String commonPrefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            commonPrefix = check(strs[i], commonPrefix);
        }
        return commonPrefix;
    }

    public String check(String str,  String commonPrefix){
        int i = 0;
        int j = 0;
        while(i < str.length() && j < commonPrefix.length()){
            if(str.charAt(i) == commonPrefix.charAt(j)){
                i++;
                j++;
            } else {
                break;
            }
        }
        commonPrefix = commonPrefix.substring(0, i);
        return commonPrefix;
    }
}