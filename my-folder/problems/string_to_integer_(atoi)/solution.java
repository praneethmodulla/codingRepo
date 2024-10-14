class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        long val = 0;
        int i = 0;
        boolean neg = false;
        if(s.length() == 0){
            return 0;
        }
        if(s.charAt(0) == '-'){
            neg = true;
            i++;
        } else if(s.charAt(i) == '+'){
            neg = false;
            i++;
        }
        while(i < s.length() && s.charAt(i) == '0'){
            i++;
        }
        if(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            val = val + (s.charAt(i) - '0');
            i++;
        } else {
            return 0;
        }
        while(i < s.length()){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                if((val > (int)Math.pow(2, 31) - 1) && !neg){
                    return (int)Math.pow(2, 31);
                } else if((val > (int)Math.pow(2,31)) && neg){
                    return -1 * (int)Math.pow(-2, 31);
                }
                val = val * 10 + (s.charAt(i) - '0');
                i++;
            } else {
                break;
            }
        }
        if((val > (int)Math.pow(2, 31) - 1) && !neg){
            return (int)Math.pow(2, 31);
        } else if((val > (int)Math.pow(2,31)) && neg){
            return -1 * (int)Math.pow(-2, 31);
        }
        if(neg){
            val = -1 * val;
            return (int)val;
        }
        return (int)val;
    }
}