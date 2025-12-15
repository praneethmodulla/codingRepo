class Solution {
    public String intToRoman(int num) {
        String result = "";
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        int power = 1;
        while(num != 0){
            int digit = num % 10;
            if(power == 1){
                if(digit >= 1 && digit <= 3){
                    for(int i = 1; i <= digit; i++){
                        result = result + map.get(1);
                    }
                } else if(digit == 4){
                    result = result + "IV";
                } else if(digit == 9){
                    result = result + "IX";
                } else if(digit >= 5){
                    result = result + "V";
                    for(int i = 6; i <= digit; i++){
                        result = result + map.get(1);
                    }
                }
            } else if(power == 10){
                if(digit >= 1 && digit <= 3){
                    for(int i = 1; i <= digit; i++){
                        result = map.get(10) + result;
                    }
                } else if(digit == 4){
                    result = "XL" + result;
                } else if(digit == 9){
                    result = "XC" + result;
                } else if(digit >= 5){
                    String res = "L";
                    for(int i = 6; i <= digit; i++){
                        res = res + map.get(10);
                    }
                    result = res + result;
                }
            } else if(power == 100){
                if(digit >= 1 && digit <= 3){
                    for(int i = 1; i <= digit; i++){
                        result = map.get(100) + result;
                    }
                } else if(digit == 4){
                    result = "CD" + result;
                } else if(digit == 9){
                    result = "CM" + result;
                } else if(digit >= 5){
                    String res = "D";
                    for(int i = 6; i <= digit; i++){
                        res = res + map.get(100);
                    }
                    result = res + result;
                }
            } else {
                if(digit >= 1 && digit <= 3){
                    for(int i = 1; i <= digit; i++){
                        result = map.get(1000) + result;
                    }
                }
            }
            num = num / 10;
            power = power * 10;
        }
        return result;
    }
}