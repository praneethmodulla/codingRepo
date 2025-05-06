class Solution {
    public String validIPAddress(String queryIP) {
        String[] ip4 = queryIP.split("\\.", -1);
        String[] ip6 = queryIP.split(":", -1);
        if(checkip4(ip4)){
            return "IPv4";
        } else if(checkip6(ip6)){
            return "IPv6";
        }
        return "Neither";
    }

    public boolean checkip4(String[] s){
        if(s.length < 4 || s.length > 4){
            return false;
        }
        for(int i = 0; i < s.length; i++){
            StringBuilder sb = new StringBuilder();
            if(s[i].length() < 1 || s[i].length() > 3){
                return false;
            }
            for(int j = 0; j < s[i].length(); j++){
                if(j == 0 && s[i].charAt(j) == '0' && s[i].length() > 1){
                    return false;
                }
                if(!Character.isDigit(s[i].charAt(j))){
                    return false;
                }
                sb.append(s[i].charAt(j));
            }   
            int x = Integer.valueOf(sb.toString());
            if(x > 255 || x < 0){
                return false;
            }
        }
        return true;
    }
    public boolean checkip6(String[] s){
        if(s.length < 8 || s.length > 8){
            return false;
        }
        for(int i = 0; i < s.length; i++){
            if(s[i].length() > 4 || s[i].length() < 1){
                return false;
            }
            for(int j = 0; j < s[i].length(); j++){
                if(!Character.isDigit(s[i].charAt(j))){
                    if(!((s[i].charAt(j) >= 'A' && s[i].charAt(j) <= 'F') || (s[i].charAt(j) >= 'a' && s[i].charAt(j) <= 'f'))){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}