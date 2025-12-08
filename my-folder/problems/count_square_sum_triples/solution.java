class Solution {
    public int countTriples(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++){
            int a = i;
            for(int j = 1; j <= n; j++){
                int b = j;
                int square = (a * a) + (b * b);
                double num = Math.sqrt(square);
                if(num % 1 == 0){
                    if(num <= n){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}