class Solution {
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length() - 1;
        while(i <= j){
            if(num.charAt(i) == '8' || num.charAt(i) == '0' || num.charAt(i) == '1'){
                if(num.charAt(j) == num.charAt(i)){
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else if(num.charAt(i) == '9'){
                if(num.charAt(j) == '6'){
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else if(num.charAt(i) == '6'){
                if(num.charAt(j) == '9'){
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}