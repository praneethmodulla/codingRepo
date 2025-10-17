class Solution {
    public String addBinary(String a, String b) {
        if(b.length() > a.length()){
            return addBinary(b, a);
        }
        StringBuilder sb = new StringBuilder();
        char carry = '0';
        int j = a.length() - 1;
        for(int i = b.length() - 1; i >= 0; i--){
            if(a.charAt(j) == '1' && b.charAt(i) == '1'){
                if(carry == '1'){
                    sb.append('1');
                    carry = '1';
                } else {
                    sb.append('0');
                    carry = '1';
                }
            } else if(a.charAt(j) == '0' && b.charAt(i) == '1'){
                if(carry == '1'){
                    sb.append('0');
                    carry = '1';
                } else {
                    sb.append('1');
                    carry = '0';
                }
            } else if(a.charAt(j) == '1' && b.charAt(i) == '0'){
                if(carry == '1'){
                    sb.append('0');
                    carry = '1';
                } else {
                    sb.append('1');
                    carry = '0';
                }
            } else {
                if(carry == '1'){
                    sb.append('1');
                    carry = '0';
                } else {
                    sb.append('0');
                }
            }
            j--;
        }
        while(j >= 0){
            if(carry == '1'){
                if(a.charAt(j) == '0'){
                    sb.append('1');
                    carry = '0';
                } else if(a.charAt(j) == '1'){
                    sb.append('0');
                    carry = '1';
                }
            } else {
                sb.append(a.charAt(j));
            }
            j--;
        }
        if(carry == '1'){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}