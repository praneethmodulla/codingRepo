class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 && j >= 0){
            int sum = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum%10;
            } else {
                carry = 0;
            }
            sb.append(sum + ""); 
            i--;
            j--;
        }
        while(i >= 0){
            int sum = num1.charAt(i) - '0' + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum%10;
            } else {
                carry = 0;
            }
            sb.append(sum + "");
            i--;
        }
        while(j >= 0){
            int sum = num2.charAt(j) - '0' + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum%10;
            } else {
                carry = 0;
            }
            sb.append(sum + "");
            j--;
        }
        if(carry == 1){
            sb.append(carry + "");
        }
        return sb.reverse().toString();
    }
}