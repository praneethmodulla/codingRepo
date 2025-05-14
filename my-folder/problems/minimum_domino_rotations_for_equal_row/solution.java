class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] numToConvert = new int[2];
        numToConvert[0] = tops[0];
        numToConvert[1] = bottoms[0];
        int[] numRotations = new int[4];
        numRotations[0] = getNums(tops, bottoms, numToConvert[0]); 
        numRotations[1] = getNums(bottoms, tops, numToConvert[0]); 
        numRotations[2] = getNums(tops, bottoms, numToConvert[1]); 
        numRotations[3] = getNums(bottoms, tops, numToConvert[1]); 
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            if(numRotations[i] >= 0){
                minVal = Math.min(minVal, numRotations[i]);
            }
        } 
        if(minVal == Integer.MAX_VALUE){
            return -1;
        }
        return minVal;
    }

    public int getNums(int[] tops, int[] bottoms, int num){
        int swap = 0;
        for(int i = 0; i < tops.length; i++){
            if(tops[i] != num){
                if(bottoms[i] == num){
                    swap++;
                } else {
                    return -1;
                }
            }
        }
        return swap;
    }
}