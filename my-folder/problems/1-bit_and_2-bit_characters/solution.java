class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while(i < bits.length){
            if(bits[i] == 0){
                if(i == bits.length - 1 && bits[i] == 0){
                    return true;
                }
                i += 1;
            } else {
                if(i == bits.length - 1 && bits[i] == 0){
                    return true;
                }
                i += 2;
            }
        }
        return false;
    }
}