class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i = num1; i <= num2; i++){
            if(i >= 10 && i <= 99){
                continue;
            }
            count += waviness(i);
        }
        return count;
    }
    public int waviness(int num){
        String str = String.valueOf(num);
        int count = 0;
        for(int i = 1; i < str.length() - 1; i++){
            if(str.charAt(i) > str.charAt(i - 1) && str.charAt(i) > str.charAt(i + 1)){
                count++;
            }
            if(str.charAt(i) < str.charAt(i - 1) && str.charAt(i) < str.charAt(i + 1)){
                count++;
            }
        }
        return count;
    }
}