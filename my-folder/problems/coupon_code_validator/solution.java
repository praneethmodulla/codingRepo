class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<String> codes = new ArrayList<String>();
        for(int j = 0; j < code.length; j++){
            if(!isActive[j]){
                continue;
            }
            String coupon = code[j];
            boolean valid = false;
            for(int i = 0; i < coupon.length(); i++){
                if(coupon.charAt(i) >= 'A' && coupon.charAt(i) <= 'Z'){
                    valid = true;
                } else if(coupon.charAt(i) >= 'a' && coupon.charAt(i) <= 'z'){
                    valid = true;
                } else if(coupon.charAt(i) >= '0' && coupon.charAt(i) <= '9'){
                    valid = true;
                } else if(coupon.charAt(i) == '_'){
                    valid = true;
                } else {
                    valid = false;
                    break;
                }
            }
            if(!valid){
                continue;
            }
            if(!map.containsKey(businessLine[j])){
                map.put(businessLine[j], new ArrayList<String>());
                map.get(businessLine[j]).add(coupon);
            } else {
                map.get(businessLine[j]).add(coupon);
            }
        }
        List<String> business = new ArrayList<String>();
        business.add("electronics");
        business.add("grocery");
        business.add("pharmacy");
        business.add("restaurant");
        for(int i = 0; i < business.size(); i++){
            List<String> validCoupons = map.getOrDefault(business.get(i), new ArrayList<String>());
            Collections.sort(validCoupons);
            for(String coupon : validCoupons){
                codes.add(coupon);
            }
        }
        return codes;
    }
}