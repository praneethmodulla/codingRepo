class Solution {
    public int minFlipsMonoIncr(String s) {
        int count1 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count1++;
            }
        }
        int min = count1;
        int count0 = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '0'){
                count0++;
            } else if(s.charAt(i) == '1'){
                count1--;
            }
            min = Math.min(min, count0 + count1);
        }
        return min;
    }
}