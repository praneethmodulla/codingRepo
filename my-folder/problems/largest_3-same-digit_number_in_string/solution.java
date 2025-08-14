class Solution {
    public String largestGoodInteger(String num) {
        String result = "";
        int i = 0;
        while(i < num.length() - 2){
            if(num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)){
                String goodnum = num.substring(i, i + 3);
                if(result.equals("")){
                    result = goodnum;
                } else {
                    int check1 = Integer.parseInt(result);
                    int check2 = Integer.parseInt(goodnum);
                    if(check1 < check2){
                        result = goodnum;
                    }
                }
                i += 3;
            } else {
                i++;
            }
        }
        return result;
    }
}