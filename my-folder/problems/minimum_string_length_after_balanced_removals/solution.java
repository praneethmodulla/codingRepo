class Solution {
    public int minLengthAfterRemovals(String s) {
        int cnta = 0;
        int cntb = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                cnta++;
            } else {
                cntb++;
            }
        }
        if(cnta == cntb){
            return 0;
        }
        return Math.abs(cnta - cntb);
    }
}