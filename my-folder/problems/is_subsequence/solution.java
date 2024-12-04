class Solution {
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()){
            return false;
        }
        return recurse(s.length() - 1, t.length() - 1, s, t);
    }

    public boolean recurse(int idx1, int idx2, String s, String t){
        if(idx1 < 0){
            return true;
        }
        if(idx2 < 0){
            return false;
        }
        if(s.charAt(idx1) == t.charAt(idx2)){
            return recurse(idx1 - 1, idx2 - 1, s, t);
        }
        return recurse(idx1, idx2 - 1, s, t);
    }
}