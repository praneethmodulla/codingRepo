class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        int cnt = 0;
        int idx1 = -1;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(idx1 != -1){
                    if(s1.charAt(idx1) != s2.charAt(i) || s2.charAt(idx1) != s1.charAt(i)){
                        return false;
                    } else {
                        cnt++;
                    }
                } else {
                    idx1 = i;
                }
            }
        }
        if(cnt == 0 && idx1 != -1){
            return false;
        } else if(cnt > 1){
            return false;
        }
        return true;
    }
}