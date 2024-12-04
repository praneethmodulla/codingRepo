class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        return recurse(str1.length() - 1, str2.length() - 1, str1, str2);
    }

    public boolean recurse(int idx1, int idx2, String str1, String str2){
        if(idx2 < 0){
            return true;
        }
        if(idx1 < 0){
            return false;
        }
        char st1Ch = str1.charAt(idx1);
        char st2Ch = str2.charAt(idx2);
        if(str2.charAt(idx2) == str1.charAt(idx1)){
            return recurse(idx1 - 1, idx2 - 1, str1, str2);
        } else if(str1.charAt(idx1) + 1 == str2.charAt(idx2)){
            return recurse(idx1 - 1, idx2 - 1, str1, str2);
        } else if(st1Ch == 'z'){
            if(st2Ch == 'a'){
                return recurse(idx1 - 1, idx2 - 1, str1, str2);
            }
        }
        return recurse(idx1 - 1, idx2, str1, str2);
    }
}