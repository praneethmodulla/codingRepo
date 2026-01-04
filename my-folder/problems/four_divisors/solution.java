class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += calculate(nums[i]);
        }
        return sum;
    }

    public int calculate(int num){
        int count = 0;
        int[] res = new int[4];
        int j = 0;
        for(int i = 1; i <= (int)Math.sqrt(num); i++){
            if(num % i == 0){
                count++;
                if(count > 2){
                    return 0;
                }
                res[j] = i;
                j++;
            }
        }
        res[3] = num;
        if(res[1] == 0){
            return 0;
        }
        if(num / res[1] == res[1]){
            return 0;
        } else {
            res[2] = num / res[1]; 
        }
        return res[0] + res[1] + res[2] + res[3];
    }
}