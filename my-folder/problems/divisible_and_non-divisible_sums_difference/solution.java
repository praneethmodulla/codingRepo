class Solution {
    public int differenceOfSums(int n, int m) {
        int num2 = 0;
        int num1 = 0;
        int total = n * (n + 1)/2;
        if(m == 1){
            return 0 - total;
        }
        for(int i = 1; i * m <= n; i++){
            num2 = num2 + (i * m);
        }
        num1 = total - num2;
        return num1 - num2;
    }
}