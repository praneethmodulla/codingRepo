class Solution {
    public int addDigits(int num) {
        if(num <= 9){
            return num;
        }
        int x = num;
        int sum = 0;
        while(x > 0){
            sum += x%10;
            x = x/10;
        }
        return addDigits(sum);
    }
}