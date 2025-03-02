class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0;
        for(int i = 0; i < damage.length; i++){
            sum += damage[i];
        }
        if(armor == 0){
            return sum + 1;
        }
        long minVal = sum + 1;
        for(int i = 0; i < damage.length; i++){
            if(armor >= damage[i]){
                if(minVal > (sum + 1 - damage[i])){
                    minVal = sum + 1 - damage[i];
                }
            } else {
                int healthDamage = damage[i] - armor;
                if(minVal > (sum + 1 - damage[i] + healthDamage)){
                    minVal = sum + 1 - damage[i] + healthDamage;
                }
            }
        }
        return minVal;
    }
}