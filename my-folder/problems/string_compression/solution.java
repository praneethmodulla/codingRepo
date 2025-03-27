class Solution {
    public int compress(char[] chars) {
         int i = 1;
         int j = 0;
         int prev = 0;
         if(chars.length == 1){
            return 1;
         }
         while(i < chars.length){
            while(i < chars.length && chars[i - 1] == chars[i]){
                i++;
            }
            int num = i - prev;
            if(num == 1){
                chars[j] = chars[prev];
                j++;
            } else if(num > 1 && num < 10){
                chars[j] = chars[prev];
                j++;
                chars[j] = String.valueOf(num).charAt(0);
                j++;
            } else {
                String s = String.valueOf(num);
                chars[j] = chars[prev];
                j++;
                for(int k = 0; k < s.length(); k++){
                    chars[j] = s.charAt(k);
                    j++; 
                }
            }
            prev = i;
            i++;
         }
         if(prev < chars.length && ((chars[prev] != chars[prev - 1])||(prev == j))){
            chars[j] = chars[prev];
            j++;
         }
         return j;
    }
}